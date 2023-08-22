from selenium import webdriver
from selenium.webdriver.common.keys import Keys

# Initialize the driver
driver = webdriver.Chrome()

# Navigate to the page
driver.get("http://localhost:8081/Aviv-tomcat/AvivApp.jsp")

# Verification 1: Check Title
assert "Stylish JSP App" in driver.title

# Verification 2: Check GitHub Button
button = driver.find_element_by_tag_name("button")
assert "Go to Git Hub" in button.text

# Verification 3: Check Header
header = driver.find_element_by_tag_name("h1")
assert "Welcome to Aviv Ben Shitrit Git Hub Page!" == header.text

# Close the browser
driver.close()

