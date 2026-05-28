package com.khasan.atm.controller;

import com.khasan.atm.service.AtmService;
import com.khasan.atm.dto.LoginRequest;
import com.khasan.atm.dto.LoginResponse;
import com.khasan.atm.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class LoginController {

    private AtmService atmService;

    public LoginController(AtmService atmService) {
        this.atmService = atmService;
    }

    @PostMapping("/api/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        User user = atmService.login(request.getCardNumber(), request.getPin());

        if (user != null) {
            LoginResponse response = new LoginResponse("Login successful", user.getName());
            return ResponseEntity.ok(response);
        } else {
            LoginResponse response = new LoginResponse("Invalid card number or PIN", null);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}