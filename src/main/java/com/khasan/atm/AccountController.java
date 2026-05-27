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
}