# Java ATM Banking System

![Maven Test](https://github.com/khasan-coding/java-atm-system-maven/actions/workflows/maven-test.yml/badge.svg)

## Project Overview

The Java ATM Banking System is a console-based and Spring Boot backend project built with Java and object-oriented programming. The project allows users to log in, select an available account, check their balance, deposit money, withdraw money, transfer money between checking and savings accounts, view transaction history, and exit the ATM system.

This project was built step by step using SDLC, Agile-style iterations, Git version control, manual functional testing, automated unit testing, Maven, and GitHub Actions CI.

The project started as a console-based Java application and is now being expanded into a Spring Boot REST API backend.

## Features

- Support for multiple users
- Each user can have a checking account, a savings account, or both
- Each user has their own account balance and transaction history
- User login with card number and PIN
- Three-attempt login limit in the console version
- Personalized welcome message
- Account selection after login
- Check account balance
- Deposit money with validation
- Withdraw money with validation
- Prevent overdraft withdrawals
- Transfer money between checking and savings accounts
- View transaction history
- Spring Boot REST API endpoints
- JSON error responses for failed API requests
- Maven-based JUnit unit testing
- GitHub Actions CI pipeline

## Object-Oriented Programming Concepts Used

- Classes and objects
- Encapsulation with private fields
- Constructors
- Getter methods
- Method behavior through deposit, withdraw, login, account selection, and transfer actions
- Has-a relationship between ATM and User
- Has-a relationship between User and Account
- Has-a relationship between Account and Transaction history
- ArrayList collections for multiple users and transaction history
- Separation of concerns between Main, ATM, User, Account, Transaction, controllers, and service classes
- Object collaboration between classes

## Project Structure

```text
java-atm-system-maven/
│
├── .github/
│   └── workflows/
│       └── maven-test.yml
│
├── docs/
│   ├── REQUIREMENTS.md
│   ├── DESIGN.md
│   ├── TEST_CASES.md
│   └── SPRING_BOOT_PLAN.md
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── khasan/
│   │               └── atm/
│   │                   ├── AtmApplication.java
│   │                   │
│   │                   ├── controller/
│   │                   │   ├── HealthController.java
│   │                   │   ├── LoginController.java
│   │                   │   └── AccountController.java
│   │                   │
│   │                   ├── service/
│   │                   │   └── AtmService.java
│   │                   │
│   │                   ├── model/
│   │                   │   ├── Main.java
│   │                   │   ├── ATM.java
│   │                   │   ├── User.java
│   │                   │   ├── Account.java
│   │                   │   └── Transaction.java
│   │                   │
│   │                   └── dto/
│   │                       ├── LoginRequest.java
│   │                       ├── LoginResponse.java
│   │                       ├── AccountSummaryResponse.java
│   │                       ├── BalanceResponse.java
│   │                       ├── AmountRequest.java
│   │                       ├── TransactionResponse.java
│   │                       ├── TransferRequest.java
│   │                       ├── TransferResponse.java
│   │                       └── ErrorResponse.java
│   │
│   └── test/
│       └── java/
│           └── com/
│               └── khasan/
│                   └── atm/
│                       ├── AccountTest.java
│                       └── UserTest.java
│
├── requests.http
├── pom.xml
└── README.md
```

## How to Run the Console Version

1. Open the project in IntelliJ IDEA.
2. Make sure the project is using Java 17 or later.
3. Make sure Maven is loaded.
4. Open `Main.java` inside `src/main/java/com/khasan/atm/model`.
5. Click Run.
6. Log in using one of the sample credentials below.

## Sample Logins

### User with Checking and Savings

Card Number: `123456`  
PIN: `1111`

### User with Checking Only

Card Number: `222222`  
PIN: `2222`

### User with Savings Only

Card Number: `333333`  
PIN: `3333`

## How to Run the Spring Boot Backend

1. Open the project in IntelliJ IDEA.
2. Run `AtmApplication.java`.
3. The backend starts on:

```text
http://localhost:8080
```

4. Test the health endpoint in the browser:

```text
http://localhost:8080/api/health
```

Expected response:

```text
ATM backend is running
```

## How to Run Tests

This project uses Maven and JUnit for automated unit testing.

To run all tests in IntelliJ:

1. Open the `src/test/java` folder.
2. Right-click the test folder or a specific test class.
3. Select Run Tests.

To run tests from the terminal:

```bash
mvn test
```

Current test classes:

- `AccountTest`
- `UserTest`

## Spring Boot API Endpoints

The Spring Boot backend currently supports the following API endpoints:

| Method | Endpoint | Purpose |
|---|---|---|
| `GET` | `/api/health` | Confirms the backend is running |
| `POST` | `/api/login` | Validates card number and PIN |
| `GET` | `/api/users/{cardNumber}/accounts` | Returns which accounts a user has |
| `GET` | `/api/accounts/{accountNumber}/balance` | Returns account balance |
| `POST` | `/api/accounts/{accountNumber}/deposit` | Deposits money into an account |
| `POST` | `/api/accounts/{accountNumber}/withdraw` | Withdraws money from an account |
| `POST` | `/api/transfer` | Transfers money between accounts |
| `GET` | `/api/accounts/{accountNumber}/transactions` | Returns transaction history |

API requests were tested using the IntelliJ HTTP Client in `requests.http`.

### API Error Responses

The API returns JSON error messages for failed requests.

Examples:

```json
{
  "message": "Account not found"
}
```

```json
{
  "message": "User not found"
}
```

Common error status codes:

| Status Code | Meaning |
|---|---|
| `400 Bad Request` | Invalid amount, insufficient funds, or invalid transfer request |
| `401 Unauthorized` | Invalid login credentials |
| `404 Not Found` | User or account was not found |

## Testing

The project includes both manual functional testing and automated unit testing.

Manual functional test scenarios are documented in:

```text
docs/TEST_CASES.md
```

Automated unit tests are written using JUnit and are located in:

```text
src/test/java
```

Current automated tests include:

- Valid deposit increases balance
- Invalid deposit does not change balance
- Valid withdrawal decreases balance
- Overdraft withdrawal does not change balance
- Invalid withdrawal does not change balance
- Correct PIN returns true
- Incorrect PIN returns false
- Correct card number returns true
- Incorrect card number returns false
- User is connected to the correct checking account
- User is connected to the correct savings account
- User with checking and savings returns true for `hasBothAccounts()`
- User with checking only returns false for `hasBothAccounts()`
- User with savings only returns false for `hasBothAccounts()`

## GitHub Actions CI

This project uses GitHub Actions to automatically run Maven tests when code is pushed.

Workflow file:

```text
.github/workflows/maven-test.yml
```

The workflow:

- Checks out the code
- Sets up Java 17
- Runs `mvn test`
- Shows a green check if tests pass

## SDLC and Agile Process

This project was built using Software Development Life Cycle concepts and Agile-style iterations.

The development process included:

- Planning the ATM project purpose and scope
- Analyzing functional and non-functional requirements
- Designing classes and responsibilities
- Developing features step by step
- Testing each feature manually
- Adding Maven and JUnit for automated unit testing
- Using Git commits after major changes
- Adding GitHub Actions CI for automated testing
- Refactoring code for better organization
- Expanding the console app into a Spring Boot backend
- Preparing documentation through README and SDLC documents

The project was developed in small increments, similar to Agile sprints. Each feature was built, tested, and committed before moving to the next feature.

## Current Version Highlights

The current version supports multiple users, checking and savings accounts, account selection, transfers, transaction history, Maven/JUnit testing, GitHub Actions CI, Spring Boot REST API endpoints, and JSON error responses.

## Future Improvements

Future improvements may include:

- Database storage for users, accounts, and transactions
- Spring Data JPA and Hibernate
- More Spring Boot service-layer refactoring
- Additional API integration tests
- Cucumber BDD functional testing
- Selenium UI testing after a web interface is created
- React frontend version
- Deployment of the backend and frontend