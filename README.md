Copy and paste this full updated README.md:

# Java ATM Banking System
## Project Overview
The Java ATM Banking System is a console-based application built with plain Java and object-oriented programming. The project allows a user to log in, check their balance, deposit money, withdraw money, view transaction history, and exit the ATM system.
This project was built step by step using SDLC, Agile-style iterations, Git version control, manual testing, and object-oriented design principles.
The Maven version of this project also includes automated unit testing with JUnit.
## Features
- Transfer money between checking and savings accounts
- Support for multiple users
- Each user has their own account balance and transaction history
- User login with card number and PIN
- Three-attempt login limit
- Personalized welcome message
- Check account balance
- Deposit money with validation
- Withdraw money with validation
- Prevent overdraft withdrawals
- View transaction history
- Exit the ATM system
## Object-Oriented Programming Concepts Used
- Classes and objects
- Encapsulation with private fields
- Constructors
- Getter methods
- Method behavior through deposit, withdraw, and login actions
- Has-a relationship between User and Account
- Has-a relationship between Account and Transaction history
- Separation of concerns between Main, ATM, User, Account, and Transaction classes
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
│   │       ├── Main.java
│   │       ├── ATM.java
│   │       ├── User.java
│   │       ├── Account.java
│   │       └── Transaction.java
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
4. Open Main.java inside src/main/java.
5. Click Run.
6. Log in using the sample credentials below.

Sample Login

Card Number: 123456
PIN: 1111

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
* User is connected to the correct account

SDLC and Agile Process

This project was built using Software Development Life Cycle concepts and Agile-style iterations.

The development process included:

* Planning the ATM project purpose and scope
* Analyzing functional and non-functional requirements
* Designing classes and responsibilities
* Developing features step by step
* Testing each feature manually
* Adding Maven and JUnit for automated unit testing
* Using Git commits after major changes
* Refactoring code for better organization
* Preparing documentation through README and SDLC documents

The project was developed in small increments, similar to Agile sprints. Each feature was built, tested, and committed before moving to the next feature.

Future Improvements

Future improvements may include:

* Support for more advanced user account management
* Separate checking and savings accounts
* Improve transfer transaction history with Transfer In and Transfer Out labels
* PIN-only login to better simulate a real ATM card insertion flow
* Java Swing or JavaFX graphical user interface
* Database storage for users, accounts, and transactions
* Additional JUnit test coverage
* Cucumber BDD functional testing
* Selenium UI testing after a web interface is created
* Spring Boot backend version
* React frontend version

