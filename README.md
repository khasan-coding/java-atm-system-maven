# Java ATM Banking System

## Project Overview

The Java ATM Banking System is a console-based application built with plain Java and object-oriented programming. The project allows a user to log in, check their balance, deposit money, withdraw money, view transaction history, and exit the ATM system.

This project was built step by step using SDLC, Agile-style iterations, Git version control, manual testing, and object-oriented design principles.

## Features

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
- Separation of concerns between Main, ATM, User, Account, and Transaction classes

## Project Structure

```text
java-atm-system/
│
├── src/
│   ├── Main.java
│   ├── ATM.java
│   ├── User.java
│   ├── Account.java
│   └── Transaction.java
│
└── README.md
```


## How to Run

1. Open the project in IntelliJ IDEA.
2. Make sure the project is using Java 17 or later.
3. Open `Main.java`.
4. Click Run.
5. Log in using the sample credentials below.

## Sample Login

Card Number: `123456`  
PIN: `1111`


## Testing

The project was tested manually through the console. Testing included:

- Successful login with correct card number and PIN
- Failed login with incorrect credentials
- Three failed login attempts
- Checking account balance
- Valid deposit
- Invalid deposit with zero or negative amount
- Valid withdrawal
- Invalid withdrawal with zero or negative amount
- Overdraft attempt with insufficient funds
- Viewing transaction history
- Exiting the ATM system

## SDLC and Agile Process

This project was built using Software Development Life Cycle concepts and Agile-style iterations.

The development process included:

- Planning the ATM project purpose and scope
- Analyzing functional and non-functional requirements
- Designing classes and responsibilities
- Developing features step by step
- Testing each feature manually
- Using Git commits after major changes
- Refactoring code for better organization
- Preparing documentation through this README

The project was developed in small increments, similar to Agile sprints. Each feature was built, tested, and committed before moving to the next feature.



## Future Improvements

Future improvements may include:

- Support for multiple users
- Separate checking and savings accounts
- Account transfer feature
- PIN-only login to better simulate a real ATM card insertion flow
- Java Swing or JavaFX graphical user interface
- Database storage for users, accounts, and transactions
- JUnit automated unit testing
- Spring Boot backend version