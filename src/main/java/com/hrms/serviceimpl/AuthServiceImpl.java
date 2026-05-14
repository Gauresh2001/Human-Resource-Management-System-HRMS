package com.hrms.serviceimpl;
import org.springframework.stereotype.Service;

import com.hrms.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public String registerUser() {
        return "User Registered Successfully";
    }

    @Override
    public String loginUser() {
        return "JWT Token Generated Successfully";
    }

}
