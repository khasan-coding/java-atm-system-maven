package com.khasan.atm;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}