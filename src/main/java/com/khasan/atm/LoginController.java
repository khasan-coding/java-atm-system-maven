package com.khasan.atm;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private AtmService atmService;

    public LoginController(AtmService atmService) {
        this.atmService = atmService;
    }

    @PostMapping("/api/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        User user = atmService.login(request.getCardNumber(), request.getPin());

        if (user != null) {
            return new LoginResponse("Login successful", user.getName());
        } else {
            return new LoginResponse("Invalid card number or PIN", null);
        }
    }
}