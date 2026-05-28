# React Frontend Plan

## Project Name

Java ATM Banking System - React Frontend Plan

## Purpose

The purpose of this plan is to describe how the current Spring Boot ATM backend can be connected to a React frontend.

The current backend exposes REST API endpoints for login, account summary, balance, deposits, withdrawals, transfers, transaction history, and error handling. The React frontend will provide a user-friendly interface that calls these backend endpoints using HTTP requests.

## Current Backend Status

The Spring Boot backend currently supports:

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

## Frontend Technology

The planned frontend will use:

- React
- Vite
- JavaScript
- HTML
- CSS
- Fetch API or Axios for HTTP requests
- VS Code as the main frontend editor

## Planned React Screens

### 1. Login Page

Purpose:

Allow the user to enter card number and PIN.

Backend endpoint:

```text
POST /api/login
```

Example request:

```json
{
  "cardNumber": "123456",
  "pin": "1111"
}
```

Example successful response:

```json
{
  "message": "Login successful",
  "name": "Khasan"
}
```

Example failed response:

```json
{
  "message": "Invalid card number or PIN",
  "name": null
}
```

Frontend behavior:

- Show input fields for card number and PIN
- Send login request to the backend
- If login succeeds, store the logged-in card number in React state
- If login fails, show an error message

---

### 2. Account Selection Page

Purpose:

Show which accounts the logged-in user has.

Backend endpoint:

```text
GET /api/users/{cardNumber}/accounts
```

Example response:

```json
{
  "name": "Khasan",
  "hasChecking": true,
  "hasSavings": true
}
```

Frontend behavior:

- Show checking account option if `hasChecking` is true
- Show savings account option if `hasSavings` is true
- Allow the user to choose an account
- Store the selected account number in React state

---

### 3. Dashboard Page

Purpose:

Show the selected account balance and available ATM actions.

Backend endpoint:

```text
GET /api/accounts/{accountNumber}/balance
```

Example response:

```json
{
  "accountNumber": "1001",
  "balance": 500.0
}
```

Frontend behavior:

- Display selected account number
- Display current balance
- Show action buttons for:
    - Deposit
    - Withdraw
    - Transfer
    - Transaction History
    - Logout

---

### 4. Deposit Form

Purpose:

Allow the user to deposit money into the selected account.

Backend endpoint:

```text
POST /api/accounts/{accountNumber}/deposit
```

Example request:

```json
{
  "amount": 100
}
```

Example response:

```json
{
  "message": "Deposit successful",
  "accountNumber": "1001",
  "newBalance": 600.0
}
```

Frontend behavior:

- Show input field for deposit amount
- Send deposit request to backend
- Show success or error message
- Update displayed balance after successful deposit

---

### 5. Withdraw Form

Purpose:

Allow the user to withdraw money from the selected account.

Backend endpoint:

```text
POST /api/accounts/{accountNumber}/withdraw
```

Example request:

```json
{
  "amount": 50
}
```

Example response:

```json
{
  "message": "Withdrawal successful",
  "accountNumber": "1001",
  "newBalance": 450.0
}
```

Frontend behavior:

- Show input field for withdrawal amount
- Send withdrawal request to backend
- Show success or error message
- Update displayed balance after successful withdrawal
- Show error message for invalid amount or insufficient funds

---

### 6. Transfer Form

Purpose:

Allow users to transfer money between checking and savings accounts.

Backend endpoint:

```text
POST /api/transfer
```

Example request:

```json
{
  "fromAccountNumber": "1001",
  "toAccountNumber": "1002",
  "amount": 100
}
```

Example response:

```json
{
  "message": "Transfer successful",
  "fromAccountNumber": "1001",
  "toAccountNumber": "1002",
  "fromAccountBalance": 400.0,
  "toAccountBalance": 1100.0
}
```

Frontend behavior:

- Show transfer form only if the user has both checking and savings accounts
- Allow transfer from checking to savings
- Allow transfer from savings to checking
- Send transfer request to backend
- Show success or error message
- Update displayed balance after successful transfer

---

### 7. Transaction History Page

Purpose:

Display transaction history for the selected account.

Backend endpoint:

```text
GET /api/accounts/{accountNumber}/transactions
```

Example response:

```json
[
  {
    "type": "Deposit",
    "amount": 100.0,
    "balanceAfterTransaction": 600.0
  },
  {
    "type": "Transfer Out",
    "amount": 50.0,
    "balanceAfterTransaction": 550.0
  }
]
```

Frontend behavior:

- Fetch transaction history from backend
- Display each transaction in a list or table
- Show transaction type, amount, and balance after transaction
- Show a message if no transactions exist

---

## Error Handling

The backend returns JSON error responses for failed requests.

Example:

```json
{
  "message": "Account not found"
}
```

Common frontend error handling:

- Display login errors under the login form
- Display deposit or withdrawal errors near the form
- Display transfer errors near the transfer form
- Display account lookup errors on the dashboard
- Avoid showing raw technical errors to the user

## State Management Plan

React state will track:

- Logged-in user name
- Logged-in card number
- Available accounts
- Selected account number
- Selected account balance
- Transaction history
- Success messages
- Error messages

Possible state variables:

```javascript
const [cardNumber, setCardNumber] = useState("");
const [userName, setUserName] = useState("");
const [selectedAccountNumber, setSelectedAccountNumber] = useState("");
const [balance, setBalance] = useState(null);
const [message, setMessage] = useState("");
const [error, setError] = useState("");
```

## React Component Plan

Possible components:

```text
App
LoginForm
AccountSelector
Dashboard
BalanceCard
DepositForm
WithdrawForm
TransferForm
TransactionHistory
MessageAlert
```

## Frontend and Backend Connection

During local development:

React frontend:

```text
http://localhost:5173
```

Spring Boot backend:

```text
http://localhost:8080
```

React will call the backend using full URLs during development, such as:

```javascript
fetch("http://localhost:8080/api/login", {
  method: "POST",
  headers: {
    "Content-Type": "application/json"
  },
  body: JSON.stringify({
    cardNumber: "123456",
    pin: "1111"
  })
});
```

## CORS Note

Because React and Spring Boot run on different ports, the backend may need CORS configuration.

Frontend:

```text
localhost:5173
```

Backend:

```text
localhost:8080
```

If the browser blocks requests, add CORS support in Spring Boot later.

## Development Order

1. Create React app with Vite.
2. Build login form.
3. Connect login form to `POST /api/login`.
4. Fetch account summary after login.
5. Build account selection UI.
6. Build dashboard and balance display.
7. Add deposit form.
8. Add withdraw form.
9. Add transfer form.
10. Add transaction history view.
11. Add error handling and loading states.
12. Improve styling.
13. Test full frontend and backend flow.

## Future Improvements

Future frontend improvements may include:

- Better UI styling
- Form validation
- Loading spinners
- Toast notifications
- React Router pages
- Authentication token support
- Deployment with Vercel or Netlify
- Full backend deployment with Render, Railway, AWS, or Azure