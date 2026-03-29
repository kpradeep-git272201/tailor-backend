package com.tailorapp.auth.service;

import com.tailorapp.auth.entity.OtpVerification;
import com.tailorapp.auth.entity.User;
import com.tailorapp.auth.repository.OtpRepository;
import com.tailorapp.auth.repository.UserRepository;


import com.tailorapp.jwt.utils.JwtUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final OtpRepository otpRepository;
    private final JwtUtils jwtUtil;

    public AuthServiceImpl(UserRepository userRepository, OtpRepository otpRepository, JwtUtils jwtUtil) {
        this.userRepository = userRepository;
        this.otpRepository = otpRepository;
        this.jwtUtil = jwtUtil;
    }

    // SEND OTP
    // =========================
    @Override
    public String sendOtp(String mobile) {
        String otpValue = "123456";
        OtpVerification otpEntity = new OtpVerification();
        otpEntity.setMobile(mobile);
        otpEntity.setOtp(otpValue);
        otpEntity.setExpiryTime(LocalDateTime.now().plusMinutes(5));
        otpEntity.setVerified(false);
        otpRepository.save(otpEntity);
        System.out.println("OTP for " + mobile + " = " + otpValue);
        return "OTP sent successfully";
    }


    // VERIFY OTP
    // =========================
    @Override
    public Map<String, Object> verifyOtp(String mobile, String otp) {

        OtpVerification otpData = otpRepository
                .findTopByMobileOrderByIdDesc(mobile)
                .orElseThrow(() -> new RuntimeException("OTP not found"));

        if (otpData.getExpiryTime().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("OTP expired");
        }

        if (!otpData.getOtp().equals(otp)) {
            throw new RuntimeException("Invalid OTP");
        }

        otpData.setVerified(true);
        otpRepository.save(otpData);


        // FIND OR CREATE USER
        // =========================
        User user = userRepository.findByMobile(mobile)
                .orElseGet(() -> {
                    User newUser = new User();
                    newUser.setMobile(mobile);
                    return userRepository.save(newUser);
                });


        // GENERATE TOKEN (UPDATED)
        // =========================
        String token = jwtUtil.generateToken(
                user.getMobile(),
                user.getUserId(),
                user.getUuid().toString()
        );


        // RESPONSE
        // =========================
        Map<String, Object> res = new HashMap<>();
        res.put("id", user.getId());
        res.put("userId", user.getUserId());
        res.put("uuid", user.getUuid());
        res.put("mobile", user.getMobile());
        res.put("token", token);

        return res;
    }
}