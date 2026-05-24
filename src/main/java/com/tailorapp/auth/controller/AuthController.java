package com.tailorapp.auth.controller;

import com.tailorapp.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> sendOtp(@RequestBody Map<String, String> req) {

        String message = authService.sendOtp(req.get("mobile"));

        if ("OTP sent successfully".equals(message)) {
            return ResponseEntity.ok().body(message);
        } else {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Failed to send OTP");
        }
    }


    @PostMapping("/verify-otp")
    public ResponseEntity<Map<String, Object>> verifyOtp(@RequestBody Map<String, String> req) {
        Map<String, Object> response = authService.verifyOtp(req.get("mobile"), req.get("otp"));
        String token = (String) response.get("token");
        response.remove("token");
        return ResponseEntity.ok()
                .header("Authorization", "Bearer " + token)
                .body(response);
    }
}
