# Test-Automation-without-pipeline
# Test Automation Graduation Project

This project focuses on automating test cases for a demo website using Selenium WebDriver, Rest-Assured, and TestNG. The primary goal is to implement an automation framework that adheres to the Test Automation Pyramid to maximize test efficiency. It includes automation for both GUI and API layers.


## . Test Cases to Automate

The first 5 test cases from the automation exercise:

1. **Test Case 1**: Register User
2. **Test Case 2**: Login User with correct email and password
3. **Test Case 3**: Login User with incorrect email and password
4. **Test Case 4**: Logout User
5. **Test Case 5**: Register User with existing email


##. Libraries/Tools

### Programming Language:
- **Java**

### Automation Libraries:
- **Web GUI**: Selenium WebDriver
- **API**: Rest-Assured
- **Test Runner**: TestNG
- **Reporting**: Allure Reporting

### Folder Structure:

- **src/main/java**: Contains the main test implementation.
  - pages package: Contains the page objects for the Page Object Model (POM).
  -   In the `pages` directory, we follow the POM principle by creating an interface-like class for each page that holds the **locators** for the elements. These files encapsulate the logic to find the web elements and provide methods for interacting with them.locators to perform the required actions on the page.
  -             CSVLoader class contains functions to read test data from a csv and pass it as a list
  -             HomePage class which conain locators and functions to intract wwith home page in GUI
  -             LoginPage class which conain locators and functions to intract wwith loginpage in GUI

- **src/tests/java**: Contains the test cases written for the automation.
  -   API.test Package
  -             LoginAPITest contains test cases related to login // Test Case 2: Login User with correct email and password -
                                                                  //Test Case 3: Login User with incorrect email and password
  -             RegestraionAPITest contains regstring new users test case //Test Case 1: Register User

  -   GUI.Test Package
  -             LoginTest  contains test cases related to login // Test Case 2: Login User with correct email and password -
                                                                //Test Case 3: Login User with incorrect email and password
                                                                  //Test Case 4: Logout User
                Regestration Test  contains test cases related to regestrain in GUI //Test Case 5: Register User with existing email
  -***ALLURE-Results*** : that serves allure reports
  
- **src/test/resources**: Contains external test data files allure-properties to specify allure reports path
  - **test-data**: External files used for data-driven testing. Sign-in.csv, signup.csv, signin-invaliddata.csv
  - **testng.xml**: TestNG configuration file for defining test execution.
  - **POM.xml** : contains project configrations


### Framework Design:

- **Page Object Model (POM)**: This design pattern was implemented for maintaining separation of concerns between test scripts and UI elements. Each page of the application will have its own class that holds the web elements and methods to interact with them.
  
- **Data-Driven Testing**: External files like **CSV** were used for data-driven testing to avoid hard-coding test data. This allows running tests with multiple datasets and configurations.


## . How to Run the Project Locally

### Prerequisites:
- Java 11 or higher
- Maven
- IDE (e.g., IntelliJ IDEA)
- Allure Commandline for generating test reports 


