from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.common.exceptions import NoSuchElementException
import time
time.sleep(20)

try:
    # Initialize the driver
    driver = webdriver.Chrome(executable_path='/usr/local/bin/chromedriver')

    # Navigate to the page
    driver.get("http://localhost:8081/Aviv-tomcat/AvivApp.jsp")

    # Verification 1: Check Title
    assert "Aviv JSP App" in driver.title

    # Verification 2: Check GitHub Button
    try:
        button = driver.find_element_by_tag_name("button")
        assert "Go to Git Hub" in button.text
    except NoSuchElementException:
        print("Button not found")

    # Verification 3: Check Header
    try:
        header = driver.find_element_by_tag_name("h1")
        assert "Welcome to Aviv Ben Shitrit Git Hub Page!" == header.text
    except NoSuchElementException:
        print("Header not found")

except Exception as e:
    print(f"An error occurred: {e}")

finally:
    # Close the browser
    driver.quit()


