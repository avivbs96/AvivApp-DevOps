from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.keys import Keys
from selenium.common.exceptions import NoSuchElementException
import time

time.sleep(20)

try:
    # Initialize the driver
    service = Service(executable_path='/usr/local/bin/chromedriver')
    driver = webdriver.Chrome(service=service)

    # Navigate to the page
    driver.get("http://localhost:8081/Aviv-tomcat/AvivApp.jsp")

    # Verification 1: Check Title
    assert "Aviv JSP App" in driver.title

    # Verification 2: Check GitHub Button
    try:
        button = driver.find_element(By.TAG_NAME, "button")
        assert "Go to Git Hub" in button.text
    except NoSuchElementException:
        print("Button not found")

    # Verification 3: Check Header
    try:
        header = driver.find_element(By.TAG_NAME, "h1")
        assert "Welcome to Aviv Ben Shitrit Git Hub Page!" == header.text
    except NoSuchElementException:
        print("Header not found")

except Exception as e:
    print(f"An error occurred: {e}")

finally:
    # Close the browser
    driver.quit()
