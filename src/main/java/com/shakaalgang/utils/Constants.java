package com.shakaalgang.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Constants {
    public enum STATUS {
        USERNAME_EXISTS, SUCCESSFULLY_REGISTERED, SUCCESSFULLY_UPDATED, FAILED_TO_UPDATE
    };
    public static final String USER_TYPE_ADMIN ="A";
}
