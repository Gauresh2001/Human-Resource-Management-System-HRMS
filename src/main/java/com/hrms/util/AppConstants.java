package com.hrms.util;

public class AppConstants {
	   // API BASE URL
    public static final String API_BASE_URL = "/api";

    // SUCCESS MESSAGES
    public static final String EMPLOYEE_ADDED =
            "Employee Added Successfully";

    public static final String EMPLOYEE_UPDATED =
            "Employee Updated Successfully";

    public static final String EMPLOYEE_DELETED =
            "Employee Deleted Successfully";

    public static final String DEPARTMENT_ADDED =
            "Department Added Successfully";

    public static final String LOGIN_SUCCESS =
            "Login Successful";

    // ERROR MESSAGES
    public static final String RESOURCE_NOT_FOUND =
            "Resource Not Found";

    public static final String INVALID_CREDENTIALS =
            "Invalid Email or Password";

    // JWT
    public static final String TOKEN_PREFIX = "Bearer ";

    public static final String HEADER_STRING = "Authorization";

    private AppConstants() {

    }
}
