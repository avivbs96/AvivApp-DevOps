from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.common.exceptions import NoSuchElementException
import time


try:
    # Initialize the driver
    driver = webdriver.Chrome(executable_path='/usr/local/bin/chromedriver')
    print("Driver initialized.")

    # Navigate to the page
    driver.get("http://localhost:8081/Aviv-tomcat/AvivApp.jsp")
    print("Navigated to the application.")

    # Verification 1: Check Title
    if "Aviv JSP App" in driver.title:
        print("Verification 1: Title check passed.")
    else:
        print("Verification 1: Title check failed.")

    # Verification 2: Check GitHub Button
    try:
        button = driver.find_element_by_tag_name("button")
        if "Go to Git Hub" in button.text:
            print("Verification 2: GitHub button check passed.")
        else:
            print("Verification 2: GitHub button check failed.")
    except NoSuchElementException:
        print("Verification 2: GitHub button not found.")

    # Verification 3: Check Header
    try:
        header = driver.find_element_by_tag_name("h1")
        if "Welcome to Aviv Ben Shitrit Git Hub Page!" == header.text:
            print("Verification 3: Header check passed.")
        else:
            print("Verification 3: Header check failed.")
    except NoSuchElementException:
        print("Verification 3: Header not found.")

except Exception as e:
    print(f"An error occurred: {e}")

finally:
    # Close the browser
    time.sleep(20)

    driver.quit()
    print("Browser closed.")
