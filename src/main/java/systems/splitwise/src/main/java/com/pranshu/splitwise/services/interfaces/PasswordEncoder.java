package com.pranshu.splitwise.services.interfaces;

public interface PasswordEncoder {

    String encode(String password);

    boolean matches(String plainText, String hashed);
}
