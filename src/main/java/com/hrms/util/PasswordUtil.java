package com.hrms.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {
	  private static final BCryptPasswordEncoder encoder =
	            new BCryptPasswordEncoder();

	    private PasswordUtil() {

	    }

	    // Encode Password
	    public static String encodePassword(
	            String password) {

	        return encoder.encode(password);
	    }

	    // Match Password
	    public static boolean matchPassword(
	            String rawPassword,
	            String encodedPassword) {

	        return encoder.matches(
	                rawPassword,
	                encodedPassword);
	    }
}
