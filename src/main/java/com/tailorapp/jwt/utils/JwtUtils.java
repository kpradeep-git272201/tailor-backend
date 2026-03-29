package com.tailorapp.jwt.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtils {

    @Value("${app.jwt.secret}")
    private String jwtSecret;

    @Value("${app.jwt.issuer}")
    private String jwtIssuer;

    @Value("${app.jwt.validity-period}")
    private long validityPeriod; // in milliseconds

    // ================================
    // 🔐 GENERATE TOKEN
    // ================================
    public String generateToken(String mobile, String userId, String uuid) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("mobile", mobile);
        claims.put("userId", userId);
        claims.put("uuid", uuid);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(mobile)
                .setIssuer(jwtIssuer)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + validityPeriod))
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }

    // ================================
    // GET CLAIMS
    // ================================
    public String getMobileFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public String getUserIdFromToken(String token) {
        return getAllClaimsFromToken(token).get("userId", String.class);
    }

    public String getUuidFromToken(String token) {
        return getAllClaimsFromToken(token).get("uuid", String.class);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    // Generic claim
    public <T> T getClaimFromToken(String token, Function<Claims, T> resolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return resolver.apply(claims);
    }

    // ================================
    // PARSE TOKEN
    // ================================
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();
    }

    // ================================
    // VALIDATION
    // ================================
    public Boolean isTokenExpired(String token) {
        return getExpirationDateFromToken(token).before(new Date());
    }

    public Boolean validateToken(String token, String mobile) {
        final String tokenMobile = getMobileFromToken(token);
        return (tokenMobile.equals(mobile) && !isTokenExpired(token));
    }

    // ================================
    // DECODE TOKEN (OPTIONAL)
    // ================================
    public Claims decodeJwt(String token) {
        try {
            return getAllClaimsFromToken(token);
        } catch (JwtException e) {
            throw new RuntimeException("Invalid JWT token");
        }
    }
}