package com.khasan.atm;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class AccountController {

    private AtmService atmService;

    public AccountController(AtmService atmService) {
        this.atmService = atmService;
    }

    @GetMapping("/api/users/{cardNumber}/accounts")
    public ResponseEntity<AccountSummaryResponse> getUserAccounts(@PathVariable String cardNumber) {
        User user = atmService.findUserByCardNumber(cardNumber);

        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        AccountSummaryResponse response = new AccountSummaryResponse(
                user.getName(),
                user.getCheckingAccount() != null,
                user.getSavingsAccount() != null
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/api/accounts/{accountNumber}/balance")
    public ResponseEntity<BalanceResponse> getAccountBalance(@PathVariable String accountNumber) {
        Account account = atmService.findAccountByAccountNumber(accountNumber);

        if (account == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        BalanceResponse response = new BalanceResponse(account.getAccountNumber(), account.getBalance());

        return ResponseEntity.ok(response);
    }

    @PostMapping("/api/accounts/{accountNumber}/deposit")
    public ResponseEntity<TransactionResponse> deposit(
            @PathVariable String accountNumber,
            @RequestBody AmountRequest request) {

        Account account = atmService.findAccountByAccountNumber(accountNumber);

        if (account == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        if (request.getAmount() <= 0) {
            TransactionResponse response = new TransactionResponse(
                    "Deposit amount must be greater than 0",
                    account.getAccountNumber(),
                    account.getBalance()
            );

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        account.deposit(request.getAmount());

        TransactionResponse response = new TransactionResponse(
                "Deposit successful",
                account.getAccountNumber(),
                account.getBalance()
        );

        return ResponseEntity.ok(response);
    }

    @PostMapping("/api/accounts/{accountNumber}/withdraw")
    public ResponseEntity<TransactionResponse> withdraw(
            @PathVariable String accountNumber,
            @RequestBody AmountRequest request) {

        Account account = atmService.findAccountByAccountNumber(accountNumber);

        if (account == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        if (request.getAmount() <= 0) {
            TransactionResponse response = new TransactionResponse(
                    "Withdrawal amount must be greater than 0",
                    account.getAccountNumber(),
                    account.getBalance()
            );

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        if (request.getAmount() > account.getBalance()) {
            TransactionResponse response = new TransactionResponse(
                    "Insufficient funds",
                    account.getAccountNumber(),
                    account.getBalance()
            );

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        account.withdraw(request.getAmount());

        TransactionResponse response = new TransactionResponse(
                "Withdrawal successful",
                account.getAccountNumber(),
                account.getBalance()
        );

        return ResponseEntity.ok(response);
    }


    @PostMapping("/api/transfer")
    public ResponseEntity<TransferResponse> transfer(@RequestBody TransferRequest request) {
        Account fromAccount = atmService.findAccountByAccountNumber(request.getFromAccountNumber());
        Account toAccount = atmService.findAccountByAccountNumber(request.getToAccountNumber());

        if (fromAccount == null || toAccount == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        if (request.getFromAccountNumber().equals(request.getToAccountNumber())) {
            TransferResponse response = new TransferResponse(
                    "Source and destination accounts must be different",
                    fromAccount.getAccountNumber(),
                    toAccount.getAccountNumber(),
                    fromAccount.getBalance(),
                    toAccount.getBalance()
            );

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        if (request.getAmount() <= 0) {
            TransferResponse response = new TransferResponse(
                    "Transfer amount must be greater than 0",
                    fromAccount.getAccountNumber(),
                    toAccount.getAccountNumber(),
                    fromAccount.getBalance(),
                    toAccount.getBalance()
            );

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        if (request.getAmount() > fromAccount.getBalance()) {
            TransferResponse response = new TransferResponse(
                    "Insufficient funds",
                    fromAccount.getAccountNumber(),
                    toAccount.getAccountNumber(),
                    fromAccount.getBalance(),
                    toAccount.getBalance()
            );

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        fromAccount.decreaseBalance(request.getAmount());
        fromAccount.addTransaction("Transfer Out", request.getAmount());

        toAccount.increaseBalance(request.getAmount());
        toAccount.addTransaction("Transfer In", request.getAmount());

        TransferResponse response = new TransferResponse(
                "Transfer successful",
                fromAccount.getAccountNumber(),
                toAccount.getAccountNumber(),
                fromAccount.getBalance(),
                toAccount.getBalance()
        );

        return ResponseEntity.ok(response);
    }
}