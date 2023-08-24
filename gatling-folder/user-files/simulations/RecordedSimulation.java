
import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class RecordedSimulation extends Simulation {

  {
    HttpProtocolBuilder httpProtocol = http
      .baseUrl("https://analytics.google.com")
      .inferHtmlResources()
      .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36");
    
    Map<CharSequence, String> headers_0 = new HashMap<>();
    headers_0.put("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7");
    headers_0.put("accept-encoding", "gzip, deflate, br");
    headers_0.put("accept-language", "en-US,en;q=0.9");
    headers_0.put("sec-ch-ua", "Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114");
    headers_0.put("sec-ch-ua-mobile", "?0");
    headers_0.put("sec-ch-ua-platform", "macOS");
    headers_0.put("sec-fetch-dest", "document");
    headers_0.put("sec-fetch-mode", "navigate");
    headers_0.put("sec-fetch-site", "same-origin");
    headers_0.put("sec-fetch-user", "?1");
    headers_0.put("upgrade-insecure-requests", "1");
    
    Map<CharSequence, String> headers_1 = new HashMap<>();
    headers_1.put("sec-ch-ua", "Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114");
    headers_1.put("sec-ch-ua-mobile", "?0");
    headers_1.put("sec-ch-ua-platform", "macOS");
    
    Map<CharSequence, String> headers_7 = new HashMap<>();
    headers_7.put("accept", "*/*");
    headers_7.put("accept-encoding", "gzip, deflate, br");
    headers_7.put("accept-language", "en-US,en;q=0.9");
    headers_7.put("origin", "https://advantageonlineshopping.com");
    headers_7.put("sec-ch-ua", "Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114");
    headers_7.put("sec-ch-ua-mobile", "?0");
    headers_7.put("sec-ch-ua-platform", "macOS");
    headers_7.put("sec-fetch-dest", "empty");
    headers_7.put("sec-fetch-mode", "no-cors");
    headers_7.put("sec-fetch-site", "cross-site");
    
    Map<CharSequence, String> headers_9 = new HashMap<>();
    headers_9.put("accept", "*/*");
    headers_9.put("accept-encoding", "gzip, deflate, br");
    headers_9.put("accept-language", "en-US,en;q=0.9");
    headers_9.put("sec-ch-ua", "Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114");
    headers_9.put("sec-ch-ua-mobile", "?0");
    headers_9.put("sec-ch-ua-platform", "macOS");
    headers_9.put("sec-fetch-dest", "empty");
    headers_9.put("sec-fetch-mode", "cors");
    headers_9.put("sec-fetch-site", "same-origin");
    
    Map<CharSequence, String> headers_11 = new HashMap<>();
    headers_11.put("accept", "*/*");
    headers_11.put("accept-encoding", "gzip, deflate, br");
    headers_11.put("accept-language", "en-US,en;q=0.9");
    headers_11.put("origin", "https://advantageonlineshopping.com");
    headers_11.put("sec-ch-ua", "Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114");
    headers_11.put("sec-ch-ua-mobile", "?0");
    headers_11.put("sec-ch-ua-platform", "macOS");
    headers_11.put("sec-fetch-dest", "font");
    headers_11.put("sec-fetch-mode", "cors");
    headers_11.put("sec-fetch-site", "same-origin");
    
    Map<CharSequence, String> headers_14 = new HashMap<>();
    headers_14.put("accept", "*/*");
    headers_14.put("accept-encoding", "gzip, deflate, br");
    headers_14.put("accept-language", "en-US,en;q=0.9");
    headers_14.put("content-type", "text/plain");
    headers_14.put("origin", "https://advantageonlineshopping.com");
    headers_14.put("sec-ch-ua", "Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114");
    headers_14.put("sec-ch-ua-mobile", "?0");
    headers_14.put("sec-ch-ua-platform", "macOS");
    headers_14.put("sec-fetch-dest", "empty");
    headers_14.put("sec-fetch-mode", "cors");
    headers_14.put("sec-fetch-site", "cross-site");
    
    Map<CharSequence, String> headers_16 = new HashMap<>();
    headers_16.put("accept", "application/json, text/plain, */*");
    headers_16.put("accept-encoding", "gzip, deflate, br");
    headers_16.put("accept-language", "en-US,en;q=0.9");
    headers_16.put("sec-ch-ua", "Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114");
    headers_16.put("sec-ch-ua-mobile", "?0");
    headers_16.put("sec-ch-ua-platform", "macOS");
    headers_16.put("sec-fetch-dest", "empty");
    headers_16.put("sec-fetch-mode", "cors");
    headers_16.put("sec-fetch-site", "same-origin");
    
    Map<CharSequence, String> headers_17 = new HashMap<>();
    headers_17.put("accept", "application/xml, text/xml, */*; q=0.01");
    headers_17.put("accept-encoding", "gzip, deflate, br");
    headers_17.put("accept-language", "en-US,en;q=0.9");
    headers_17.put("content-type", "text/xml; charset=UTF-8");
    headers_17.put("origin", "https://advantageonlineshopping.com");
    headers_17.put("sec-ch-ua", "Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114");
    headers_17.put("sec-ch-ua-mobile", "?0");
    headers_17.put("sec-ch-ua-platform", "macOS");
    headers_17.put("sec-fetch-dest", "empty");
    headers_17.put("sec-fetch-mode", "cors");
    headers_17.put("sec-fetch-site", "same-origin");
    headers_17.put("soapaction", "com.advantage.online.store.accountserviceGetAccountConfigurationRequest");
    headers_17.put("x-requested-with", "XMLHttpRequest");
    
    Map<CharSequence, String> headers_21 = new HashMap<>();
    headers_21.put("accept", "text/html");
    headers_21.put("accept-encoding", "gzip, deflate, br");
    headers_21.put("accept-language", "en-US,en;q=0.9");
    headers_21.put("sec-ch-ua", "Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114");
    headers_21.put("sec-ch-ua-mobile", "?0");
    headers_21.put("sec-ch-ua-platform", "macOS");
    headers_21.put("sec-fetch-dest", "empty");
    headers_21.put("sec-fetch-mode", "cors");
    headers_21.put("sec-fetch-site", "same-origin");
    
    Map<CharSequence, String> headers_40 = new HashMap<>();
    headers_40.put("accept", "image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8");
    headers_40.put("accept-encoding", "gzip, deflate, br");
    headers_40.put("accept-language", "en-US,en;q=0.9");
    headers_40.put("sec-ch-ua", "Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114");
    headers_40.put("sec-ch-ua-mobile", "?0");
    headers_40.put("sec-ch-ua-platform", "macOS");
    headers_40.put("sec-fetch-dest", "image");
    headers_40.put("sec-fetch-mode", "no-cors");
    headers_40.put("sec-fetch-site", "cross-site");
    
    Map<CharSequence, String> headers_43 = new HashMap<>();
    headers_43.put("accept", "*/*");
    headers_43.put("accept-encoding", "gzip, deflate, br");
    headers_43.put("accept-language", "en-US,en;q=0.9");
    headers_43.put("content-type", "text/plain;charset=UTF-8");
    headers_43.put("origin", "https://advantageonlineshopping.com");
    headers_43.put("sec-ch-ua", "Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114");
    headers_43.put("sec-ch-ua-mobile", "?0");
    headers_43.put("sec-ch-ua-platform", "macOS");
    headers_43.put("sec-fetch-dest", "empty");
    headers_43.put("sec-fetch-mode", "no-cors");
    headers_43.put("sec-fetch-site", "cross-site");
    headers_43.put("x-client-data", "CIm2yQEIorbJAQipncoBCLfeygEIkqHLAQiGoM0BGMDLzAE=");
    
    Map<CharSequence, String> headers_51 = new HashMap<>();
    headers_51.put("accept", "image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8");
    headers_51.put("accept-encoding", "gzip, deflate, br");
    headers_51.put("accept-language", "en-US,en;q=0.9");
    headers_51.put("sec-ch-ua", "Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114");
    headers_51.put("sec-ch-ua-mobile", "?0");
    headers_51.put("sec-ch-ua-platform", "macOS");
    headers_51.put("sec-fetch-dest", "image");
    headers_51.put("sec-fetch-mode", "no-cors");
    headers_51.put("sec-fetch-site", "same-origin");
    
    Map<CharSequence, String> headers_56 = new HashMap<>();
    headers_56.put("accept", "*/*");
    headers_56.put("accept-encoding", "gzip, deflate, br");
    headers_56.put("accept-language", "en-US,en;q=0.9");
    headers_56.put("origin", "https://advantageonlineshopping.com");
    headers_56.put("sec-ch-ua", "Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114");
    headers_56.put("sec-ch-ua-mobile", "?0");
    headers_56.put("sec-ch-ua-platform", "macOS");
    headers_56.put("sec-fetch-dest", "empty");
    headers_56.put("sec-fetch-mode", "no-cors");
    headers_56.put("sec-fetch-site", "cross-site");
    headers_56.put("x-client-data", "CIm2yQEIorbJAQipncoBCLfeygEIkqHLAQiGoM0BGMDLzAE=");
    
    String uri1 = "https://www.google-analytics.com";
    
    String uri2 = "https://advantageonlineshopping.com";
    
    String uri4 = "https://www.googletagmanager.com/gtag/js";

    ScenarioBuilder scn = scenario("RecordedSimulation")
      .exec(
        http("request_0")
          .get(uri2 + "/")
          .headers(headers_0)
          .resources(
            http("request_1")
              .get(uri2 + "/css/images/Down_arrow.svg")
              .headers(headers_1),
            http("request_2")
              .get(uri2 + "/vendor/requirejs/require.js")
              .headers(headers_1),
            http("request_3")
              .get(uri4 + "?id=G-TBPYED8WSW")
              .headers(headers_1),
            http("request_4")
              .get(uri2 + "/main.min.js")
              .headers(headers_1),
            http("request_5")
              .get(uri1 + "/analytics.js")
              .headers(headers_1),
            http("request_6")
              .get(uri2 + "/css/images/logo.png")
              .headers(headers_1),
            http("request_7")
              .post(uri1 + "/g/collect?v=2&tid=G-TBPYED8WSW&gtm=45je38g0&_p=997218530&cid=138019709.1692360870&ul=en-us&sr=1280x800&uaa=x86&uab=64&uafvl=Not.A%252FBrand%3B8.0.0.0%7CChromium%3B114.0.5735.198%7CGoogle%2520Chrome%3B114.0.5735.198&uamb=0&uam=&uap=macOS&uapv=12.6.5&uaw=0&_s=1&sid=1692360869&sct=1&seg=1&dl=https%3A%2F%2Fadvantageonlineshopping.com%2F&dr=https%3A%2F%2Fwww.google.com%2F&dt=%C2%A0Advantage%20Shopping&en=page_view&_ee=1")
              .headers(headers_7),
            http("request_8")
              .get(uri2 + "/css/images/closeDark.png")
              .headers(headers_1),
            http("request_9")
              .get(uri2 + "/services.properties")
              .headers(headers_9),
            http("request_10")
              .get(uri2 + "/css/images/favicon.ico")
              .headers(headers_1),
            http("request_11")
              .get(uri2 + "/css/fonts/roboto_medium_macroman/Roboto-Medium-webfont.woff")
              .headers(headers_11),
            http("request_12")
              .get(uri2 + "/css/fonts/roboto_regular_macroman/Roboto-Regular-webfont.woff")
              .headers(headers_11),
            http("request_13")
              .get(uri2 + "/css/fonts/roboto_light_macroman/Roboto-Light-webfont.woff")
              .headers(headers_11),
            http("request_14")
              .post(uri1 + "/j/collect?v=1&_v=j101&a=997218530&t=pageview&_s=1&dl=https%3A%2F%2Fadvantageonlineshopping.com%2F&dr=https%3A%2F%2Fwww.google.com%2F&dp=%2F&ul=en-us&de=UTF-8&dt=%C2%A0Advantage%20Shopping&sd=24-bit&sr=1280x800&vp=1280x150&je=0&_u=AACAAEABAAAAACAAI~&jid=&gjid=&cid=138019709.1692360870&tid=UA-81334227-1&_gid=1464172342.1692360871&_slc=1&z=1539954245")
              .headers(headers_14),
            http("request_15")
              .get(uri4 + "?id=G-56EMNRF2S2&cx=c&_slc=1")
              .headers(headers_1),
            http("request_16")
              .get(uri2 + "/catalog/api/v1/DemoAppConfig/parameters/by_tool/ALL")
              .headers(headers_16),
            http("request_17")
              .post(uri2 + "/accountservice/ws/GetAccountConfigurationRequest")
              .headers(headers_17)
              .body(RawFileBody("recordedsimulation/0017_request.dat")),
            http("request_18")
              .get(uri2 + "/catalog/api/v1/categories")
              .headers(headers_16),
            http("request_19")
              .get(uri2 + "/catalog/api/v1/deals/search?dealOfTheDay=true")
              .headers(headers_16),
            http("request_20")
              .get(uri2 + "/app/tempFiles/popularProducts.json")
              .headers(headers_16),
            http("request_21")
              .get(uri2 + "/app/views/home-page.html")
              .headers(headers_21),
            http("request_22")
              .get(uri2 + "/css/images/Special-offer.jpg")
              .headers(headers_1),
            http("request_23")
              .get(uri2 + "/css/images/chat_logo.png")
              .headers(headers_1),
            http("request_24")
              .get(uri2 + "/css/images/GoUp.png")
              .headers(headers_1),
            http("request_25")
              .get(uri2 + "/css/images/facebook.png")
              .headers(headers_1),
            http("request_26")
              .get(uri2 + "/css/images/twitter.png")
              .headers(headers_1),
            http("request_27")
              .get(uri2 + "/css/images/linkedin.png")
              .headers(headers_1),
            http("request_28")
              .get(uri2 + "/css/images/arrow_right.png")
              .headers(headers_1),
            http("request_29")
              .get(uri2 + "/catalog/fetchImage?image_id=speakers")
              .headers(headers_1),
            http("request_30")
              .get(uri2 + "/catalog/fetchImage?image_id=tablets")
              .headers(headers_1),
            http("request_31")
              .get(uri2 + "/catalog/fetchImage?image_id=laptops")
              .headers(headers_1),
            http("request_32")
              .get(uri2 + "/catalog/fetchImage?image_id=mice")
              .headers(headers_1),
            http("request_33")
              .get(uri2 + "/catalog/fetchImage?image_id=headphones")
              .headers(headers_1),
            http("request_34")
              .get(uri2 + "/css/images/Banner1.jpg")
              .headers(headers_1),
            http("request_35")
              .get(uri2 + "/css/images/Banner2.jpg")
              .headers(headers_1),
            http("request_36")
              .get(uri2 + "/css/images/Banner3.jpg")
              .headers(headers_1),
            http("request_37")
              .get(uri2 + "/css/images/Popular-item3.jpg")
              .headers(headers_1),
            http("request_38")
              .get(uri2 + "/css/images/Popular-item2.jpg")
              .headers(headers_1),
            http("request_39")
              .get(uri2 + "/css/images/Popular-item1.jpg")
              .headers(headers_1),
            http("request_40")
              .get(uri1 + "/collect?v=1&_v=j101&a=997218530&t=pageview&_s=2&dl=https%3A%2F%2Fadvantageonlineshopping.com%2F&dr=https%3A%2F%2Fwww.google.com%2F&dp=%2F&ul=en-us&de=UTF-8&dt=%C2%A0Advantage%20Shopping&sd=24-bit&sr=1280x800&vp=1280x150&je=0&_u=CACAAEABAAAAACACI~&jid=&gjid=&cid=138019709.1692360870&tid=UA-81334227-1&_gid=1464172342.1692360871&z=1433926174")
              .headers(headers_40),
            http("request_41")
              .get(uri2 + "/css/fonts/roboto_bold_macroman/Roboto-Bold-webfont.woff")
              .headers(headers_11),
            http("request_42")
              .get(uri2 + "/css/fonts/roboto_thin_macroman/Roboto-Thin-webfont.woff")
              .headers(headers_11)
          )
      )
      .pause(2)
      .exec(
        http("request_43")
          .post("/g/collect?v=2&tid=G-56EMNRF2S2&gtm=45je38g0&_p=997218530&ul=en-us&sr=1280x800&cid=138019709.1692360870&uaa=x86&uab=64&uafvl=Not.A%252FBrand%3B8.0.0.0%7CChromium%3B114.0.5735.198%7CGoogle%2520Chrome%3B114.0.5735.198&uamb=0&uam=&uap=macOS&uapv=12.6.5&uaw=0&_eu=ABAI&dl=https%3A%2F%2Fadvantageonlineshopping.com%2F&dr=https%3A%2F%2Fwww.google.com%2F&dp=%2F&dt=%C2%A0Advantage%20Shopping&sid=1692360871&sct=1&seg=1&_s=1")
          .headers(headers_43)
          .body(RawFileBody("recordedsimulation/0043_request.txt"))
          .resources(
            http("request_44")
              .post(uri1 + "/g/collect?v=2&tid=G-TBPYED8WSW&gtm=45je38g0&_p=997218530&cid=138019709.1692360870&ul=en-us&sr=1280x800&uaa=x86&uab=64&uafvl=Not.A%252FBrand%3B8.0.0.0%7CChromium%3B114.0.5735.198%7CGoogle%2520Chrome%3B114.0.5735.198&uamb=0&uam=&uap=macOS&uapv=12.6.5&uaw=0&_eu=AEA&_s=2&sid=1692360869&sct=1&seg=1&dl=https%3A%2F%2Fadvantageonlineshopping.com%2F&dr=https%3A%2F%2Fwww.google.com%2F&dt=%C2%A0Advantage%20Shopping&en=scroll&epn.percent_scrolled=90")
              .headers(headers_7)
          )
      )
      .pause(25)
      .exec(
        http("request_45")
          .get(uri2 + "/catalog/api/v1/products/21")
          .headers(headers_16)
          .resources(
            http("request_46")
              .get(uri2 + "/catalog/api/v1/categories/all_data")
              .headers(headers_16),
            http("request_47")
              .get(uri2 + "/catalog/api/v1/categories/4/products")
              .headers(headers_16),
            http("request_48")
              .get(uri2 + "/app/views/product-page.html")
              .headers(headers_21),
            http("request_49")
              .get(uri2 + "/css/main.min.css")
              .headers(headers_1),
            http("request_50")
              .get(uri1 + "/collect?v=1&_v=j101&a=997218530&t=pageview&_s=3&dl=https%3A%2F%2Fadvantageonlineshopping.com%2F&dr=https%3A%2F%2Fwww.google.com%2F&dp=%2Fproduct%2F21&ul=en-us&de=UTF-8&dt=%C2%A0Advantage%20Shopping&sd=24-bit&sr=1280x800&vp=1280x150&je=0&_u=CACAAEABAAAAACACIAC~&jid=&gjid=&cid=138019709.1692360870&tid=UA-81334227-1&_gid=1464172342.1692360871&z=1667712352")
              .headers(headers_40),
            http("request_51")
              .get(uri2 + "/css/images/review_right.png")
              .headers(headers_51),
            http("request_52")
              .get(uri2 + "/css/images/review_Left_disabled.png")
              .headers(headers_51),
            http("request_53")
              .get(uri2 + "/css/images/reviewUser.png")
              .headers(headers_51),
            http("request_54")
              .get(uri2 + "/catalog/fetchImage?image_id=4300")
              .headers(headers_51),
            http("request_55")
              .get(uri2 + "/catalog/fetchImage?image_id=4301")
              .headers(headers_51)
          )
      )
      .pause(4)
      .exec(
        http("request_56")
          .post("/g/collect?v=2&tid=G-56EMNRF2S2&gtm=45je38g0&_p=997218530&ul=en-us&sr=1280x800&cid=138019709.1692360870&uaa=x86&uab=64&uafvl=Not.A%252FBrand%3B8.0.0.0%7CChromium%3B114.0.5735.198%7CGoogle%2520Chrome%3B114.0.5735.198&uamb=0&uam=&uap=macOS&uapv=12.6.5&uaw=0&_eu=ABAI&_s=2&dl=https%3A%2F%2Fadvantageonlineshopping.com%2F&dr=https%3A%2F%2Fwww.google.com%2F&dp=%2Fproduct%2F21&dt=%C2%A0Advantage%20Shopping&sid=1692360871&sct=1&seg=1&en=page_view&_ee=1&_et=6129")
          .headers(headers_56)
      );

setUp(scn.injectOpen(rampUsers(100).during(Duration.ofSeconds(10)))).protocols(httpProtocol);
  }
}
