# Spring Boot Backend Plan
## Project Name
Java com.khasan.atm.model.ATM Banking System - Spring Boot Backend Plan
## Purpose
The purpose of this plan is to describe how the current Java console com.khasan.atm.model.ATM project can be converted into a Spring Boot backend API.
The current project uses console input with `Scanner` and displays output with `System.out.println()`. In the Spring Boot version, the com.khasan.atm.model.ATM system will receive HTTP requests and return JSON responses.
## Current Console Version
The current application uses:
- `Scanner` to read user input
- `System.out.println()` to display menu options and messages
- `com.khasan.atm.model.ATM.java` to control login, account selection, menu actions, and transfers
- `com.khasan.atm.model.User.java` to store user information
- `com.khasan.atm.model.Account.java` to handle balance, deposit, withdrawal, validation, and transaction history
- `com.khasan.atm.model.Transaction.java` to store transaction records
## What Will Change
The console menu will eventually be replaced by REST API endpoints.
Instead of this:
```text
com.khasan.atm.model.User types into console
com.khasan.atm.model.ATM reads input with Scanner
com.khasan.atm.model.ATM prints result with System.out.println()
```

The Spring Boot version will use this:

Client sends HTTP request
Spring Boot controller receives request
Service layer runs business logic
Backend returns JSON response

Classes We Can Keep

The following classes can still be useful:

* com.khasan.atm.model.User
* com.khasan.atm.model.Account
* com.khasan.atm.model.Transaction

These classes contain the core business logic and data model.

Classes That Will Change

com.khasan.atm.model.ATM.java will likely be replaced or refactored because it depends on console input.

The Spring Boot version will use:

* Controllers
* Services
* Request classes
* Response classes

Planned API Endpoints

Method	Endpoint	Purpose
POST	/api/login	Validate card number and PIN
GET	/api/users/{cardNumber}/accounts	Get available accounts for a user
GET	/api/accounts/{accountNumber}/balance	Get account balance
POST	/api/accounts/{accountNumber}/deposit	Deposit money into an account
POST	/api/accounts/{accountNumber}/withdraw	Withdraw money from an account
POST	/api/transfer	Transfer money between checking and savings
GET	/api/accounts/{accountNumber}/transactions	View transaction history

Example Login Request

{
  "cardNumber": "123456",
  "pin": "1111"
}

Example Login Response

{
  "message": "Login successful",
  "name": "Khasan"
}

Example Deposit Request

{
  "amount": 100
}

Example Deposit Response

{
  "message": "Deposit successful",
  "newBalance": 600
}

Future Tools

The Spring Boot version may use:

* Spring Boot Web
* Maven
* REST APIs
* JSON
* Postman for API testing
* H2 database for beginner persistence
* JPA/Hibernate for database access
* React frontend later

Development Order

1. Create a new Spring Boot project or branch.
2. Move core model classes into the Spring Boot project.
3. Create service classes for account and user logic.
4. Create controller classes for API endpoints.
5. Test endpoints with Postman.
6. Add database storage.
7. Connect React frontend later.
