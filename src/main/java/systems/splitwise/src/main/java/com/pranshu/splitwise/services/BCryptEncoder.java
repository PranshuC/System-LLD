package com.pranshu.splitwise.services;

import com.pranshu.splitwise.interfaces.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Not implementing BCryptPasswordEncoder spring class directly
 * 1. Decoupling application code from framework code
 *  - scope for later adding custom business logic
 * 2. Later switch from spring BCrypt implementation to different
 *  - just 1 class reference change
 */
@Service
public class BCryptEncoder implements PasswordEncoder {

    // Dependency : spring-security-web
    private final BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
    @Override
    public String encode(String password) {
        return bCryptEncoder.encode(password);
    }

    @Override
    public boolean matches(String plainText, String hashed) {
        return bCryptEncoder.matches(plainText, hashed);
    }
}
