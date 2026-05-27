# Requirements Document

## Project Name

Java ATM Banking System

## Project Purpose

The purpose of this project is to build a console-based ATM system using plain Java and object-oriented programming. The system allows users to log in, select an available account, check balance, deposit money, withdraw money, transfer money between checking and savings accounts, view transaction history, and exit the ATM.

## Functional Requirements

- The system shall allow a user to log in using a card number and PIN.
- The system shall allow a maximum of three login attempts.
- The system shall display a personalized welcome message after successful login.
- The system shall support multiple users.
- The system shall allow users to have a checking account, a savings account, or both.
- The system shall allow the user to select an available account after login.
- The system shall allow the user to check the selected account balance.
- The system shall allow the user to deposit money into the selected account.
- The system shall allow the user to withdraw money from the selected account.
- The system shall prevent withdrawals that exceed the available balance.
- The system shall store successful deposits and withdrawals in transaction history.
- The system shall allow the user to view transaction history for the selected account.
- The system shall allow users with both checking and savings accounts to transfer money between those accounts.
- The system shall prevent transfers when the user does not have both checking and savings accounts.
- The system shall allow the user to exit the ATM.

## Non-Functional Requirements

- The system should be easy to use through a clear console menu.
- The system should protect account data using private fields.
- The system should validate user input before changing any account balance.
- The system should be organized using separate classes and responsibilities.
- The system should be maintainable and easy to expand in future versions.
- The system should avoid crashes when a user does not have a checking account or savings account.
- The system should keep account logic separate from ATM menu logic.

## Business Rules

- A deposit amount must be greater than zero.
- A withdrawal amount must be greater than zero.
- A user cannot withdraw more than the available account balance.
- A user has a maximum of three login attempts.
- A successful deposit or withdrawal must update the selected account balance.
- Invalid deposits and withdrawals must not change the account balance.
- Only successful deposits and withdrawals are stored in transaction history.
- A user may have a checking account, a savings account, or both.
- A transfer amount must be greater than zero.
- A transfer can only happen if the user has both checking and savings accounts.
- A transfer cannot exceed the available balance in the source account.
- A successful transfer must decrease the source account balance and increase the destination account balance.
- Users with only one account type cannot use the transfer feature.