# Automated Login Form Testing Using Selenium

## Project Overview
This project automates the testing of a login form for the demo website `https://the-internet.herokuapp.com/login` using Selenium WebDriver in Java. The goal is to validate different login scenarios, ensuring robust authentication handling.

## Test Cases Implemented
- **Valid Login:** Checks login with correct credentials (`tomsmith` / `SuperSecretPassword!`) and verifies successful navigation to the Secure Area page.
- **Invalid Login:** Tests login with incorrect username and password, asserts the appearance of an error message.
- **Empty Fields:** Simulates logging in with username and password fields left blank; asserts required field validation appears.

## Tools and Technologies
- Java
- Selenium WebDriver
- ChromeDriver (or any browser driver)

## Setup Instructions
1. Clone or extract the project folder.
2. Make sure Java (version 8 or above) is installed.
3. Download and set up the correct version of ChromeDriver, and add it to your system path if necessary.
4. Import the project into your IDE (like IntelliJ IDEA or Eclipse).
5. Ensure the required Selenium WebDriver Java libraries (JARs or Maven/Gradle dependencies) are added to the project.

## Running the Tests
- Open your IDE and load the test classes.
- Run the test files directly (using your IDE's test runner or JUnit/TestNG configuration).
- Observe test execution and assertion results in the console.

## Bonus (Optional)
- The project can be extended to implement data-driven testing, e.g., using a CSV file for input scenarios.

## Deliverables
- Java code files implementing Selenium tests.
- This README file with full instructions.

