# Design Document

## Project Name

Java ATM Banking System

## Design Overview

The Java ATM Banking System is designed using object-oriented programming principles. The system separates responsibilities across multiple classes so that each class has one main purpose. This improves readability, maintainability, and future scalability.

## Class Responsibilities

| Class | Responsibility |
|---|---|
| `Main` | Starts the program by creating the main objects and calling the ATM system |
| `ATM` | Handles login, menu display, user input, and ATM actions |
| `User` | Stores user information such as name, card number, PIN, and connected account |
| `Account` | Handles balance, deposits, withdrawals, validation, and transaction history |
| `Transaction` | Represents one transaction record such as a deposit or withdrawal |

## Class Relationships

- `ATM` has a `User`
- `User` has an `Account`
- `Account` has many `Transaction` objects

## OOP Concepts Used

- Classes and objects
- Encapsulation with private fields
- Constructors
- Getter methods
- Has-a relationships
- Separation of concerns
- Object collaboration between classes

## Design Reasoning

The project was designed this way to avoid placing all logic inside `Main.java`. Instead, each class has a clear job. This makes the code easier to understand, test, debug, and expand.

For example, withdrawal validation belongs in the `Account` class because it is an account rule. Login logic belongs in the `ATM` class because the ATM controls user access. Transaction details belong in the `Transaction` class because each transaction should be represented as its own object.

## Future Design Improvements

Future versions may include:

- `CheckingAccount` and `SavingsAccount` classes
- Inheritance and polymorphism for different account types
- Account transfer functionality
- File or database storage
- JUnit automated testing
- JavaFX or React user interface