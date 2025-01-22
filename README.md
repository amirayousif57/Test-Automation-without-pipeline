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
  - ****pages**: Contains the page objects for the Page Object Model (POM).
  -   In the `pages` directory, we follow the POM principle by creating an interface-like class for each page that holds the **locators** for the elements. These files encapsulate the logic to find the web elements and provide methods for interacting with them.locators to perform the required actions on the page.
  -             CSVLoader class contains functions to read test data from a csv and pass it as a list
  -             HomePage class which conain locators and functions to intract wwith home page in GUI
  -             LoginPage class which conain locators and functions to intract wwith loginpage in GUI
  - ****tests**: Contains the test cases written for the automation.
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

- **target**: Folder where the Allure report and other build artifacts will be stored.

### Framework Design:

- **Page Object Model (POM)**: This design pattern will be implemented for maintaining separation of concerns between test scripts and UI elements. Each page of the application will have its own class that holds the web elements and methods to interact with them.
  
- **Data-Driven Testing**: External files like **CSV**, **JSON**, or **Excel** will be used for data-driven testing to avoid hard-coding test data. This allows running tests with multiple datasets and configurations.

- **Configurations**: URLs, environment details, and browser settings will be stored in configuration files to keep the code flexible and easily maintainable.

- **Test Reporting**: **Allure Reporting** will be used to generate detailed test execution reports, including passed and failed test cases.

### Notes:
- Ensure that the framework remains stable after updates and code changes.
- Handle test data properly to allow test execution without manual intervention.
- Follow Java naming conventions and SOLID principles for writing clean and maintainable code.
- **Parallel Execution**: Tests will be executed in parallel to save time and improve efficiency.

## 5. CI/CD Implementation with GitHub Actions

The project implements **Continuous Integration (CI)** and **Continuous Deployment (CD)** using GitHub Actions.

- **CI**: GitHub Actions will automatically build, test, and validate changes made to the project. It will also run tests in parallel to reduce build times.
- **CD**: Optionally, deployment steps can be added (e.g., deploying to a staging or production environment after a successful test run).

Allure reports will be uploaded as an artifact in the GitHub Actions workflow, and screenshots of successful and failed tests will be included for reference.

## 6. Deliverables

- **GitHub Repository Link**: The project code is hosted on GitHub, including the automation test scripts and configurations.
- **README file**: This file explaining the folder structure, tools used, configurations, and important notes.
- **Demo Video**: A video demonstrating the execution of the test cases.
- **CI/CD Results Report**: If CI/CD is implemented using GitHub Actions, the results will be available with Allure Report as an artifact, including screenshots of both successful and failed tests.

## 7. How to Run the Project Locally

### Prerequisites:
- Java 11 or higher
- Maven
- IDE (e.g., IntelliJ IDEA, Eclipse)
- Allure Commandline for generating test reports (optional)

### Steps:

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/GraduationProject.git
