package com.tailorapp.auth.service;

import com.tailorapp.auth.entity.OtpVerification;
import com.tailorapp.auth.entity.UserEntity;
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

    public AuthServiceImpl(UserRepository userRepository,
                           OtpRepository otpRepository,
                           JwtUtils jwtUtil) {
        this.userRepository = userRepository;
        this.otpRepository = otpRepository;
        this.jwtUtil = jwtUtil;
    }

    // =========================
    // SEND OTP
    // =========================
    @Override
    public String sendOtp(String mobile) {

        String otpValue = "123456"; // TODO: random OTP later

        OtpVerification otpEntity = new OtpVerification();
        otpEntity.setMobile(mobile);
        otpEntity.setOtp(otpValue);
        otpEntity.setExpiryTime(LocalDateTime.now().plusMinutes(5));
        otpEntity.setVerified(false);

        otpRepository.save(otpEntity);

        System.out.println("OTP for " + mobile + " = " + otpValue);

        return "OTP sent successfully";
    }

    // =========================
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

        // =========================
        // FIND OR CREATE USER
        // =========================
        UserEntity user = userRepository.findByPhoneNumber(mobile)
                .orElseGet(() -> {
                    UserEntity newUser = new UserEntity();
                    newUser.setPhoneNumber(mobile);
                    newUser.setFullName("New User");
                    newUser.setEmail(mobile + "@temp.com");
                    return userRepository.save(newUser);
                });

        // =========================
        // GENERATE TOKEN
        // =========================
        String token = jwtUtil.generateToken(
                user.getPhoneNumber(),
                String.valueOf(user.getUserId()),
                user.getRole()
        );

        // =========================
        // RESPONSE
        // =========================
        Map<String, Object> res = new HashMap<>();
        res.put("userId", user.getUserId());
        res.put("mobile", user.getPhoneNumber());
        res.put("name", user.getFullName());
        res.put("token", token);

        return res;
    }
}