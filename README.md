# Java com.khasan.atm.ATM Banking System

![Maven Test](https://github.com/khasan-coding/java-atm-system-maven/actions/workflows/maven-test.yml/badge.svg)

## Project Overview
The Java com.khasan.atm.ATM Banking System is a console-based application built with plain Java and object-oriented programming. The project allows users to log in, select an available account, check their balance, deposit money, withdraw money, transfer money between checking and savings accounts, view transaction history, and exit the com.khasan.atm.ATM system.
This project was built step by step using SDLC, Agile-style iterations, Git version control, manual testing, and object-oriented design principles.
The Maven version of this project also includes automated unit testing with JUnit.
## Features
- Support for multiple users
- Each user can have a checking account, a savings account, or both
- Each user has their own account balance and transaction history
- com.khasan.atm.User login with card number and PIN
- Three-attempt login limit
- Personalized welcome message
- com.khasan.atm.Account selection after login
- Check account balance
- Deposit money with validation
- Withdraw money with validation
- Prevent overdraft withdrawals
- Transfer money between checking and savings accounts
- View transaction history
- Exit the com.khasan.atm.ATM system
## Object-Oriented Programming Concepts Used
- Classes and objects
- Encapsulation with private fields
- Constructors
- Getter methods
- Method behavior through deposit, withdraw, login, account selection, and transfer actions
- Has-a relationship between com.khasan.atm.ATM and com.khasan.atm.User
- Has-a relationship between com.khasan.atm.User and com.khasan.atm.Account
- Has-a relationship between com.khasan.atm.Account and com.khasan.atm.Transaction history
- ArrayList collections for multiple users and transaction history
- Separation of concerns between com.khasan.atm.Main, com.khasan.atm.ATM, com.khasan.atm.User, com.khasan.atm.Account, and com.khasan.atm.Transaction classes
- Object collaboration between classes
## Project Structure
```text
java-atm-system-maven/
│
├── docs/
│   ├── REQUIREMENTS.md
│   ├── DESIGN.md
│   └── TEST_CASES.md
│
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── com.khasan.atm.Main.java
│   │       ├── com.khasan.atm.ATM.java
│   │       ├── com.khasan.atm.User.java
│   │       ├── com.khasan.atm.Account.java
│   │       └── com.khasan.atm.Transaction.java
│   │
│   └── test/
│       └── java/
│           ├── AccountTest.java
│           └── UserTest.java
│
├── pom.xml
│
└── README.md
```
How to Run

1. Open the project in IntelliJ IDEA.
2. Make sure the project is using Java 17 or later.
3. Make sure Maven is loaded.
4. Open com.khasan.atm.Main.java inside src/main/java.
5. Click Run.
6. Log in using the sample credentials below.

Sample Logins

com.khasan.atm.User with Checking and Savings

Card Number: 123456
PIN: 1111

com.khasan.atm.User with Checking Only

Card Number: 222222
PIN: 2222

com.khasan.atm.User with Savings Only

Card Number: 333333
PIN: 3333

How to Run Tests

This project uses Maven and JUnit for automated unit testing.

To run all tests in IntelliJ:

1. Open the src/test/java folder.
2. Right-click the test folder or a specific test class.
3. Select Run Tests.

To run tests from the terminal:

mvn test

Current test classes:

* AccountTest
* UserTest

Testing

The project includes both manual testing documentation and automated unit testing.

Manual test scenarios are documented in:

docs/TEST_CASES.md

Automated unit tests are written using JUnit and are located in:

src/test/java

Current automated tests include:

* Valid deposit increases balance
* Invalid deposit does not change balance
* Valid withdrawal decreases balance
* Overdraft withdrawal does not change balance
* Invalid withdrawal does not change balance
* Correct PIN returns true
* Incorrect PIN returns false
* Correct card number returns true
* Incorrect card number returns false
* com.khasan.atm.User is connected to the correct checking account
* com.khasan.atm.User is connected to the correct savings account
* com.khasan.atm.User with checking and savings returns true for hasBothAccounts()
* com.khasan.atm.User with checking only returns false for hasBothAccounts()
* com.khasan.atm.User with savings only returns false for hasBothAccounts()

SDLC and Agile Process

This project was built using Software Development Life Cycle concepts and Agile-style iterations.

The development process included:

* Planning the com.khasan.atm.ATM project purpose and scope
* Analyzing functional and non-functional requirements
* Designing classes and responsibilities
* Developing features step by step
* Testing each feature manually
* Adding Maven and JUnit for automated unit testing
* Using Git commits after major changes
* Refactoring code for better organization
* Preparing documentation through README and SDLC documents

The project was developed in small increments, similar to Agile sprints. Each feature was built, tested, and committed before moving to the next feature.

Current Version Highlights

The current version supports multiple users and account selection. A user may have a checking account, a savings account, or both. Transfers are available only when the user has both checking and savings accounts.

Future Improvements

Future improvements may include:

* Support for more advanced user account management
* PIN-only login to better simulate a real com.khasan.atm.ATM card insertion flow
* Java Swing or JavaFX graphical user interface
* Database storage for users, accounts, and transactions
* Additional JUnit test coverage
* Cucumber BDD functional testing
* Selenium UI testing after a web interface is created
* Spring Boot backend version
* React frontend version

