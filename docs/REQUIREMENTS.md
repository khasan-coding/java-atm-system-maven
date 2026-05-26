# Requirements Document

## Project Name

Java ATM Banking System

## Project Purpose

The purpose of this project is to build a console-based ATM system using plain Java and object-oriented programming. The system allows a user to log in, check balance, deposit money, withdraw money, view transaction history, and exit the ATM.

## Functional Requirements

- The system shall allow a user to log in using a card number and PIN.
- The system shall allow a maximum of three login attempts.
- The system shall display a personalized welcome message after successful login.
- The system shall allow the user to check the account balance.
- The system shall allow the user to deposit money.
- The system shall allow the user to withdraw money.
- The system shall prevent withdrawals that exceed the available balance.
- The system shall store successful deposits and withdrawals in transaction history.
- The system shall allow the user to view transaction history.
- The system shall allow the user to exit the ATM.

## Non-Functional Requirements

- The system should be easy to use through a clear console menu.
- The system should protect account data using private fields.
- The system should validate user input before changing the balance.
- The system should be organized using separate classes and responsibilities.
- The system should be maintainable and easy to expand in future versions.

## Business Rules

- A deposit amount must be greater than zero.
- A withdrawal amount must be greater than zero.
- A user cannot withdraw more than the available account balance.
- A user has a maximum of three login attempts.
- A successful deposit or withdrawal must update the account balance.
- Invalid deposits and withdrawals must not change the account balance.
- Only successful deposits and withdrawals are stored in transaction history.