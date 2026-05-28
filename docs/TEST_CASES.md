# Test Cases

## Project Name

Java com.khasan.atm.model.ATM Banking System

## Testing Overview

The project includes both manual functional testing and automated unit testing.

Manual functional test cases are documented in this file. These tests verify full com.khasan.atm.model.ATM user workflows through the console, such as login, account selection, deposits, withdrawals, transfers, transaction history, and exit behavior.

Automated unit tests are written using JUnit and are located in `src/test/java`. These tests verify core business logic in smaller pieces, such as deposit validation, withdrawal validation, PIN checks, card number checks, and account relationship logic.
## Manual Test Cases

| Test ID | Scenario | Steps | Expected Result | Status |
|---|---|---|---|---|
| T1 | Successful login | Enter card number `123456` and PIN `1111` | Login successful message appears and com.khasan.atm.model.ATM menu opens | Passed |
| T2 | Failed login | Enter correct card number but wrong PIN | Error message appears and user gets another attempt | Passed |
| T3 | Three failed login attempts | Enter wrong login credentials three times | Access denied message appears and menu does not open | Passed |
| T4 | Check balance | Log in and choose option `1` | Current balance is displayed | Passed |
| T5 | Valid deposit | Choose option `2` and deposit `100` | Balance increases by `100` | Passed |
| T6 | Invalid deposit | Choose option `2` and enter `-100` | Error message appears and balance does not change | Passed |
| T7 | Valid withdrawal | Choose option `3` and withdraw `50` | Balance decreases by `50` | Passed |
| T8 | Invalid withdrawal | Choose option `3` and enter `-50` | Error message appears and balance does not change | Passed |
| T9 | Overdraft attempt | Choose option `3` and enter amount greater than balance | Insufficient funds message appears and balance does not change | Passed |
| T10 | View transaction history | Make a valid deposit and withdrawal, then choose option `4` | com.khasan.atm.model.Transaction history displays successful transactions | Passed |
| T11 | Invalid menu option | Enter a number outside the available menu options | Error message appears asking user to choose a valid option | Passed |
| T12 | Exit com.khasan.atm.model.ATM | Choose option `6` | Goodbye message appears and program ends | Passed |
| T13 | Login as second user | Enter card number `222222` and PIN `2222` | Login successful message appears and com.khasan.atm.model.ATM welcomes Alex | Passed |
| T14 | Login as third user | Enter card number `333333` and PIN `3333` | Login successful message appears and com.khasan.atm.model.ATM welcomes Maria | Passed |
| T15 | Separate user balances | Log in as Alex and check balance | Alex's account balance displays independently from other users | Passed |
| T16 | Select checking account | Log in as Khasan and choose checking account | Checking account is selected and com.khasan.atm.model.ATM menu opens | Passed |
| T17 | Select savings account | Log in as Khasan and choose savings account | Savings account is selected and com.khasan.atm.model.ATM menu opens | Passed |
| T18 | Checking-only user account selection | Log in as Alex | Checking account is selected automatically | Passed |
| T19 | Savings-only user account selection | Log in as Maria | Savings account is selected automatically | Passed |
| T20 | Transfer from checking to savings | Log in as Khasan, choose transfer option, transfer `100` from checking to savings, then view transaction history for both accounts | Checking balance decreases by `100`, savings balance increases by `100`, checking history shows `Transfer Out`, and savings history shows `Transfer In` | Passed |
| T21 | Transfer from savings to checking | Log in as Khasan, choose transfer option, transfer `100` from savings to checking, then view transaction history for both accounts | Savings balance decreases by `100`, checking balance increases by `100`, savings history shows `Transfer Out`, and checking history shows `Transfer In` | Passed |
| T22 | Transfer unavailable for checking-only user | Log in as Alex and choose transfer option | Message appears saying transfer is only available with both checking and savings accounts | Passed |
| T23 | Transfer unavailable for savings-only user | Log in as Maria and choose transfer option | Message appears saying transfer is only available with both checking and savings accounts | Passed |
| T24 | Invalid transfer amount | Log in as Khasan and enter a transfer amount of `-100` | Error message appears and balances do not change | Passed |
| T25 | Transfer with insufficient funds | Log in as Khasan and transfer more than the source account balance | Insufficient funds message appears and balances do not change | Passed |

## Automated Unit Tests

Automated unit tests are written using JUnit and are located in:

```text
src/test/java