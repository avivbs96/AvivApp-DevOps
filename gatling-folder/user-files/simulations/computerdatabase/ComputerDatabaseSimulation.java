package computerdatabase;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import java.util.concurrent.ThreadLocalRandom;

public class ComputerDatabaseSimulation extends Simulation {

    HttpProtocolBuilder httpProtocol =
        http.baseUrl("https://computer-database.gatling.io")
            .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
            .acceptLanguageHeader("en-US,en;q=0.5")
            .acceptEncodingHeader("gzip, deflate")
            .userAgentHeader(
                "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0"
            );

    FeederBuilder<String> feeder = csv("search.csv").random();

    ChainBuilder search =
        exec(http("Home").get("/"))
            .pause(1)
            .feed(feeder)
            .exec(
                http("Search")
                    .get("/computers?f=#{searchCriterion}")
                    .check(
                        css("a:contains('#{searchComputerName}')", "href").saveAs("computerUrl")
                    )
            )
            .pause(1)
            .exec(
                http("Select")
                    .get("#{computerUrl}")
                    .check(status().is(200))
            )
            .pause(1);

    ChainBuilder browse =
        repeat(4, "i").on(
            exec(
                http("Page #{i}")
                    .get("/computers?p=#{i}")
            ).pause(1)
        );

    ChainBuilder edit =
        tryMax(2)
            .on(
                exec(
                    http("Form")
                        .get("/computers/new")
                )
                    .pause(1)
                    .exec(
                        http("Post")
                            .post("/computers")
                            .formParam("name", "Beautiful Computer")
                            .formParam("introduced", "2012-05-30")
                            .formParam("discontinued", "")
                            .formParam("company", "37")
                            .check(
                                status().is(
                                    session -> 200 + ThreadLocalRandom.current().nextInt(2)
                                )
                            )
                    )
            )
            .exitHereIfFailed();

    ScenarioBuilder users = scenario("Users").exec(search, browse);
    ScenarioBuilder admins = scenario("Admins").exec(search, browse, edit);

    // Stress Test Scenario
    ScenarioBuilder stressTest = scenario("Stress Test")
        .exec(http("Stress Home")
            .get("/"))
        .pause(1)
        .exec(http("Stress Search")
            .get("/computers"))
        .pause(1);

    {
        setUp(
            users.injectOpen(rampUsers(10).during(10)),
            admins.injectOpen(rampUsers(2).during(10)),
            // New stress test setup
            stressTest.injectOpen(rampUsers(70).during(120))
        ).protocols(httpProtocol);
    }
}
