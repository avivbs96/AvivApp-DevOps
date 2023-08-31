# import pytest
# from selenium import webdriver
# from selenium.webdriver.common.by import By
# from selenium.webdriver.chrome.service import Service
# from selenium.webdriver.common.keys import Keys
# from selenium.common.exceptions import NoSuchElementException

# @pytest.fixture(scope="module")
# def setup_driver():
#     service = Service(executable_path='/usr/local/bin/chromedriver')
#     driver = webdriver.Chrome(service=service)
#     yield driver
#     driver.quit()

# def test_title(setup_driver):
#     driver = setup_driver
#     driver.get("http://localhost:8081/Aviv-tomcat/AvivApp.jsp")
#     assert "Aviv JSP App" in driver.title
#     print("Verification 1: Title check passed.")

# def test_github_button(setup_driver):
#     driver = setup_driver
#     try:
#         button = driver.find_element(By.TAG_NAME, "button")
#         assert "Go to Git Hub" in button.text
#         print("Verification 2: GitHub button check passed.")
#     except NoSuchElementException:
#         pytest.fail("Button not found")

# def test_header(setup_driver):
#     driver = setup_driver
#     try:
#         header = driver.find_element(By.TAG_NAME, "h1")
#         assert "Welcome to Aviv Ben Shitrit Git Hub Page!" == header.text
#         print("Verification 3: Header check passed.")
#     except NoSuchElementException:
#         pytest.fail("Header not found")


# # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # 
# # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # 
# # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # 

# import pytest
# from browsermobproxy import Server
# from selenium import webdriver
# from selenium.webdriver.common.by import By
# from selenium.webdriver.chrome.service import Service
# from selenium.webdriver.common.keys import Keys
# from selenium.common.exceptions import NoSuchElementException

# @pytest.fixture(scope="module")
# def setup_driver():
#     service = Service(executable_path='/usr/local/bin/chromedriver')
#     driver = webdriver.Chrome(service=service)
#     yield driver
#     driver.quit()

# @pytest.fixture(scope="function")
# def browsermob_proxy():
#     server = Server("/Users/Aviv/Desktop/devOps/FinalProject/AvivApp-DevOps/browsermob-proxy-2.1.4/bin/browsermob-proxy")  # Replace with your actual path
#     server.start()
#     proxy = server.create_proxy()
#     yield proxy
#     server.stop()

# def test_title_and_capture_har(setup_driver, browsermob_proxy):
#     driver = setup_driver
#     proxy = browsermob_proxy

#     # Set up a Selenium WebDriver with the proxy configuration
#     chrome_options = webdriver.ChromeOptions()
#     chrome_options.add_argument(f'--proxy-server={proxy.proxy}')
#     driver = webdriver.Chrome(service=driver.service, options=chrome_options)

#     # Start capturing network traffic
#     proxy.new_har("aviv_app")

#     # Navigate to your web page
#     driver.get("http://localhost:8081/Aviv-tomcat/AvivApp.jsp")
#     assert "Aviv JSP App" in driver.title
#     print("Verification 1: Title check passed.")

#     # Stop capturing network traffic and save the HAR file
#     har = proxy.har
#     with open("aviv_app.har", "w") as har_file:
#         json.dump(har, har_file)

#     # Continue with your remaining tests
#     try:
#         button = driver.find_element(By.TAG_NAME, "button")
#         assert "Go to Git Hub" in button.text
#         print("Verification 2: GitHub button check passed.")
#     except NoSuchElementException:
#         pytest.fail("Button not found")

#     try:
#         header = driver.find_element(By.TAG_NAME, "h1")
#         assert "Welcome to Aviv Ben Shitrit Git Hub Page!" == header.text
#         print("Verification 3: Header check passed.")
#     except NoSuchElementException:
#         pytest.fail("Header not found")

#     driver.quit()


# # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # 
# # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # 
# # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # 


import pytest
import json
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.keys import Keys
from selenium.common.exceptions import NoSuchElementException

@pytest.fixture(scope="module")
def setup_driver():
    service = Service(executable_path='/usr/local/bin/chromedriver')
    chrome_options = Options()
    chrome_options.add_argument("--proxy-server=127.0.0.1:8082")  # Use your BrowserMob Proxy address
    driver = webdriver.Chrome(service=service, options=chrome_options)
    yield driver
    driver.quit()

def capture_har(driver, har_filename):
    performance_data = driver.execute_script("return window.performance.getEntries();")
    with open(har_filename, 'w') as har_file:
        json.dump(performance_data, har_file)

def test_title_and_capture_har(setup_driver):
    driver = setup_driver
    driver.get("http://localhost:8081/Aviv-tomcat/AvivApp.jsp")
    assert "Aviv JSP App" in driver.title
    print("Verification 1: Title check passed.")
    
    # Capture network traffic as HAR file
    capture_har(driver, 'aviv_app.har')

def test_github_button(setup_driver):
    driver = setup_driver
    try:
        button = driver.find_element(By.TAG_NAME, "button")
        assert "Go to Git Hub" in button.text
        print("Verification 2: GitHub button check passed.")
    except NoSuchElementException:
        pytest.fail("Button not found")

def test_header(setup_driver):
    driver = setup_driver
    try:
        header = driver.find_element(By.TAG_NAME, "h1")
        assert "Welcome to Aviv Ben Shitrit Git Hub Page!" == header.text
        print("Verification 3: Header check passed.")
    except NoSuchElementException:
        pytest.fail("Header not found")
