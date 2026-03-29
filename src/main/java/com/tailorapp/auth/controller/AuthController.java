package com.tailorapp.auth.controller;

import com.tailorapp.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;
    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    @PostMapping("/send-otp")
    public String sendOtp(@RequestBody Map<String, String> req) {

        return authService.sendOtp(req.get("mobile"));
    }

    @PostMapping("/verify-otp")
    public Object verifyOtp(@RequestBody Map<String, String> req) {
        return authService.verifyOtp(req.get("mobile"), req.get("otp"));
    }
}
