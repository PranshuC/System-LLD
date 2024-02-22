package com.pranshu.splitwise.interfaces;

public interface PasswordEncoder {

    String encode(String password);

    // We don't want to know decoded password but
    // if the entered password by user is correct or not
    // Abstract password decoding, which is security risk
    boolean matches(String plainText, String hashed);
}
