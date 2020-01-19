package com.shakaalgang.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CommonUtils {
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static boolean riskProfileCheck(double totalAppliedLoan, double totalPaidAmount) {
        return totalAppliedLoan < totalPaidAmount;
    }
    public boolean testCheck(double totalAppliedLoan, double totalPaidAmount) {
        return totalAppliedLoan < totalPaidAmount;
    }
}
