import pytest
import json
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.keys import Keys
from selenium.common.exceptions import NoSuchElementException
from browsermobproxy import Server

@pytest.fixture(scope="module")
def setup_proxy():
    server = Server()
    server.start()
    proxy = server.create_proxy()
    yield proxy
    server.stop()

@pytest.fixture(scope="module")
def setup_driver(setup_proxy):
    proxy = setup_proxy
    chrome_options = webdriver.ChromeOptions()
    chrome_options.add_argument("--proxy-server={0}".format(proxy.proxy))
    service = Service(executable_path='/usr/local/bin/chromedriver')
    driver = webdriver.Chrome(service=service, options=chrome_options)
    yield driver
    driver.quit()

def test_title(setup_driver, setup_proxy):
    driver = setup_driver
    proxy = setup_proxy
    proxy.new_har("aviv_har_title")

    driver.get("http://localhost:8081/Aviv-tomcat/AvivApp.jsp")
    
    assert "Aviv JSP App" in driver.title
    print("Verification 1: Title check passed.")
    
    har_data = proxy.har
    with open("network_logs_title.har", "w") as f:
        json.dump(har_data, f)

def test_github_button(setup_driver, setup_proxy):
    driver = setup_driver
    proxy = setup_proxy
    proxy.new_har("aviv_har_github_button")

    driver.get("http://localhost:8081/Aviv-tomcat/AvivApp.jsp")
    
    try:
        button = driver.find_element(By.TAG_NAME, "button")
        assert "Go to Git Hub" in button.text
        print("Verification 2: GitHub button check passed.")
    except NoSuchElementException:
        pytest.fail("Button not found")
    
    har_data = proxy.har
    with open("network_logs_github_button.har", "w") as f:
        json.dump(har_data, f)

def test_header(setup_driver, setup_proxy):
    driver = setup_driver
    proxy = setup_proxy
    proxy.new_har("aviv_har_header")

    driver.get("http://localhost:8081/Aviv-tomcat/AvivApp.jsp")

    try:
        header = driver.find_element(By.TAG_NAME, "h1")
        assert "Welcome to Aviv Ben Shitrit Git Hub Page!" == header.text
        print("Verification 3: Header check passed.")
    except NoSuchElementException:
        pytest.fail("Header not found")

    har_data = proxy.har
    with open("network_logs_header.har", "w") as f:
        json.dump(har_data, f)
