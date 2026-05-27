# Test Cases

## Project Name

Java ATM Banking System

## Testing Overview

The project was manually tested through the console. The purpose of testing was to verify that login, deposit, withdrawal, balance inquiry, transaction history, and exit functionality worked correctly.

## Manual Test Cases

| Test ID | Scenario | Steps | Expected Result | Status |
|---|---|---|---|---|
| T1 | Successful login | Enter card number `123456` and PIN `1111` | Login successful message appears and ATM menu opens | Passed |
| T2 | Failed login | Enter correct card number but wrong PIN | Error message appears and user gets another attempt | Passed |
| T3 | Three failed login attempts | Enter wrong login credentials three times | Access denied message appears and menu does not open | Passed |
| T4 | Check balance | Log in and choose option `1` | Current balance is displayed | Passed |
| T5 | Valid deposit | Choose option `2` and deposit `100` | Balance increases by `100` | Passed |
| T6 | Invalid deposit | Choose option `2` and enter `-100` | Error message appears and balance does not change | Passed |
| T7 | Valid withdrawal | Choose option `3` and withdraw `50` | Balance decreases by `50` | Passed |
| T8 | Invalid withdrawal | Choose option `3` and enter `-50` | Error message appears and balance does not change | Passed |
| T9 | Overdraft attempt | Choose option `3` and enter amount greater than balance | Insufficient funds message appears and balance does not change | Passed |
| T10 | View transaction history | Make a valid deposit and withdrawal, then choose option `4` | Transaction history displays successful transactions | Passed |
| T11 | Invalid menu option | Enter a number outside `1-5` | Error message appears asking user to choose a valid option | Passed |
| T12 | Exit ATM | Choose option `5` | Goodbye message appears and program ends | Passed |
| T13 | Login as second user | Enter card number `222222` and PIN `2222` | Login successful message appears and ATM welcomes Alex | Passed |
| T14 | Login as third user | Enter card number `333333` and PIN `3333` | Login successful message appears and ATM welcomes Maria | Passed |
| T15 | Separate user balances | Log in as Alex and check balance | Alex's account balance displays independently from other users | Passed |


## Notes

These tests were performed manually through the IntelliJ console. A future improvement would be to add automated unit tests using JUnit.