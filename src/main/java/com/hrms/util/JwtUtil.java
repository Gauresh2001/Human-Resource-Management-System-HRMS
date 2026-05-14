package com.hrms.util;

import java.util.Date;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;


public class JwtUtil {
	 private static final String SECRET_KEY =
	            "hrmsSecretKeyhrmsSecretKeyhrmsSecretKey";

	    private static final long EXPIRATION =
	            86400000;

	    private JwtUtil() {

	    }

	    // Generate Secret Key
	    private static SecretKey getSignKey() {

	        return Keys.hmacShaKeyFor(
	                SECRET_KEY.getBytes());
	    }

	    // Generate Token
	    public static String generateToken(
	            String email) {

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

	    // Extract Claims
	    public static Claims extractClaims(
	            String token) {

	        return Jwts.parser()
	                .verifyWith(getSignKey())
	                .build()
	                .parseSignedClaims(token)
	                .getPayload();
	    }

	    // Extract Username
	    public static String extractEmail(
	            String token) {

	        return extractClaims(token)
	                .getSubject();
	    }

	    // Validate Token
	    public static boolean validateToken(
	            String token,
	            String email) {

	        String extractedEmail =
	                extractEmail(token);

	        return extractedEmail.equals(email)
	                && !isTokenExpired(token);
	    }

	    // Check Expiration
	    private static boolean isTokenExpired(
	            String token) {

	        return extractClaims(token)
	                .getExpiration()
	                .before(new Date());
	    }

}
