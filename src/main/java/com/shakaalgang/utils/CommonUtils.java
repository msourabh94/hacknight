package com.shakaalgang.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CommonUtils {
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
