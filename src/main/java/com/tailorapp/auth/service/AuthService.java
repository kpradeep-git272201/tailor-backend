package com.tailorapp.auth.service;
import java.util.Map;

public interface AuthService {
    String sendOtp(String mobile);
    Map<String, Object> verifyOtp(String mobile, String otp);
}
