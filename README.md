Note: To opent the report invoke this URL: https://malisgit25.github.io/gdit-workday-e2e-selenium-framework/reports/index.html  

# GDIT-Woryday-Career-E2E-Framework

## Overview

This project is a **robust End-to-End (E2E) Test Automation Framework** built using **Java + Selenium + TestNG**. It is designed following **industry best practices** to support scalable, maintainable, and parallel test execution.

The framework supports:

* Cross-browser testing
* Parallel execution
* Data-driven testing
* CI/CD integration
* Detailed reporting & logging

## Tech Stack

* **Language:** Java
* **Automation Tool:** Selenium WebDriver
* **Test Framework:** TestNG
* **Build Tool:** Maven
* **Driver Management:** WebDriverManager
* **Reporting:** ExtentReports
* **Logging:** Log4j2
* **CI/CD:** Jenkins (optional integration)

## Project Structure


com.gdit
│
├── basetest
│     └── BaseTest.java
│
├── factory
│     └── DriverFactory.java
│
├── pages
│     └── Page Object classes
│
├── tests
│     └── Test classes
│
├── utils
│     └── Utility classes
│
├── reporting
│     └── ExtentManager.java
│
├── listeners
│     └── TestNG Listeners
│
└── resources
      ├── config.properties
      ├── log4j2.xml
      └── test data files

##  Framework Design

### DriverFactory Pattern

* Centralized WebDriver creation
* Supports multiple browsers (Chrome, Edge, etc.)
* Uses `ThreadLocal` for thread-safe execution

### BaseTest

* Handles test setup and teardown
* Loads configuration
* Initializes browser via DriverFactory
* Manages logging and reporting

### Page Object Model (POM)

* Each page is represented as a class
* Separates UI logic from test logic
* Improves maintainability and readability


##  Configuration

Update `config.properties`:

browser=chrome
url=https://gdit.wd5.myworkdayjobs.com/en-US/External_Career_Site/login


## How to Run Tests

### Run via Maven

mvn clean test

### Run specific TestNG suite

mvn test -DsuiteXmlFile=testng.xml

## Parallel Execution

Configured using **TestNG**:

<suite name="Suite" parallel="tests" thread-count="3">

* Thread-safe execution using `ThreadLocal`
* Each test runs in its own browser instance

## Reporting

* ExtentReports generates HTML reports after execution
* Includes:

  * Test steps
  * Pass/Fail status
  * Screenshots (if integrated)

---

##  Logging

* Log4j2 is used for logging
* Logs stored in `/Logs` directory
* Tracks:

  * Test execution flow
  * Errors and failures

---

##  CI/CD Integration

Framework can be integrated with Jenkins:

Pipeline flow:

Code Commit → Build → Execute Tests → Generate Reports

## Key Features

* Scalable architecture
* Clean separation of concerns
* Easy browser switching
* Supports parallel execution
* Extensible for API + UI testing

## 📌 Best Practices Used

* Page Object Model (POM)
* DriverFactory Design Pattern
* ThreadLocal for parallel execution
* Externalized configuration
* Reusable utilities

## 👨‍💻 Author

Md Ali

