package com.hrms.security;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private static final String SECRET_KEY =
            "hrmsSecretKeyhrmsSecretKeyhrmsSecretKey";

    private static final long EXPIRATION =
            86400000;

    private SecretKey getSignKey() {

        return Keys.hmacShaKeyFor(
                SECRET_KEY.getBytes());
    }

    // Generate Token
    public String generateToken(String email) {

        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(
                        new Date(
                                System.currentTimeMillis()
                                        + EXPIRATION))
                .signWith(
                        getSignKey(),
                        SignatureAlgorithm.HS256)
                .compact();
    }

    // Extract Email
    public String extractEmail(String token) {

        return extractClaims(token)
                .getSubject();
    }

    // Extract Claims
    public Claims extractClaims(String token) {

        return Jwts.parser()
                .verifyWith(getSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    // Validate Token
    public boolean validateToken(
            String token,
            String email) {

        String extractedEmail =
                extractEmail(token);

        return extractedEmail.equals(email)
                && !isTokenExpired(token);
    }

    // Check Expiration
    private boolean isTokenExpired(
            String token) {

        return extractClaims(token)
                .getExpiration()
                .before(new Date());
    }
}
