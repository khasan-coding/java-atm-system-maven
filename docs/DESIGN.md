# Design Document

## Project Name

Java com.khasan.atm.model.ATM Banking System

## Design Overview

The Java com.khasan.atm.model.ATM Banking System is designed using object-oriented programming principles. The system separates responsibilities across multiple classes so that each class has one main purpose. This improves readability, maintainability, testing, and future scalability.

The current version supports multiple users, checking and savings accounts, account selection, deposits, withdrawals, transaction history, and transfers between checking and savings accounts.

## Class Responsibilities

| Class | Responsibility |
|---|---|
| `com.khasan.atm.model.Main` | Starts the program by creating account objects, user objects, the user list, and the com.khasan.atm.model.ATM system |
| `com.khasan.atm.model.ATM` | Handles login, account selection, menu display, user input, com.khasan.atm.model.ATM actions, and transfers |
| `com.khasan.atm.model.User` | Stores user information such as name, card number, PIN, checking account, and savings account |
| `com.khasan.atm.model.Account` | Handles account balance, deposits, withdrawals, validation, and transaction history |
| `com.khasan.atm.model.Transaction` | Represents one transaction record such as a deposit or withdrawal |

## Class Relationships

- `com.khasan.atm.model.ATM` has many `com.khasan.atm.model.User` objects through an `ArrayList<com.khasan.atm.model.User>`.
- `com.khasan.atm.model.ATM` tracks the currently logged-in user with `currentUser`.
- `com.khasan.atm.model.User` may have a checking account.
- `com.khasan.atm.model.User` may have a savings account.
- `com.khasan.atm.model.User` can have both checking and savings accounts, which enables transfers.
- `com.khasan.atm.model.Account` has many `com.khasan.atm.model.Transaction` objects through an `ArrayList<com.khasan.atm.model.Transaction>`.

## OOP Concepts Used

- Classes and objects
- Encapsulation with private fields
- Constructors
- Getter methods
- Has-a relationships
- ArrayList collections for multiple users and transaction history
- Separation of concerns
- Object collaboration between classes

## Design Reasoning

The project was designed this way to avoid placing all logic inside `com.khasan.atm.model.Main.java`. Instead, each class has a clear job. This makes the code easier to understand, test, debug, and expand.

For example, withdrawal validation belongs in the `com.khasan.atm.model.Account` class because it is an account rule. Login and account selection belong in the `com.khasan.atm.model.ATM` class because the com.khasan.atm.model.ATM controls user access and user interaction. com.khasan.atm.model.Transaction details belong in the `com.khasan.atm.model.Transaction` class because each transaction should be represented as its own object.

The `com.khasan.atm.model.User` class was updated to support both checking and savings accounts. This allows the system to model a more realistic banking scenario where a user may have one account type or both account types. The com.khasan.atm.model.ATM checks which accounts are available and allows account selection based on the user’s accounts.

The transfer feature is handled by the `com.khasan.atm.model.ATM` class because the transfer is a user action from the com.khasan.atm.model.ATM menu. The transfer still relies on the `com.khasan.atm.model.Account` class methods, such as `withdraw()` and `deposit()`, to update balances safely.

## Future Design Improvements

Future versions may include:

- `CheckingAccount` and `SavingsAccount` subclasses
- Inheritance and polymorphism for different account types
- Improved transfer transaction records using `Transfer In` and `Transfer Out` transaction types
- File or database storage
- Additional JUnit automated testing
- Cucumber BDD functional testing
- Selenium UI testing after a web interface is created
- Spring Boot backend version
- React frontend version