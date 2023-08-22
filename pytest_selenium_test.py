import pytest
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.common.exceptions import NoSuchElementException

@pytest.fixture(scope="module")
def setup_driver():
    driver = webdriver.Chrome(executable_path='/usr/local/bin/chromedriver')
    yield driver
    driver.quit()

def test_title(setup_driver):
    driver = setup_driver
    driver.get("http://localhost:8081/Aviv-tomcat/AvivApp.jsp")
    assert "Aviv JSP App" in driver.title
    print("Verification 1: Title check passed.")

def test_github_button(setup_driver):
    driver = setup_driver
    try:
        button = driver.find_element_by_tag_name("button")
        assert "Go to Git Hub" in button.text
        print("Verification 2: GitHub button check passed.")
    except NoSuchElementException:
        pytest.fail("Button not found")
        
def test_header(setup_driver):
    driver = setup_driver
    try:
        header = driver.find_element_by_tag_name("h1")
        assert "Welcome to Aviv Ben Shitrit Git Hub Page!" == header.text
        print("Verification 3: Header check passed.")
    except NoSuchElementException:
        pytest.fail("Header not found")
