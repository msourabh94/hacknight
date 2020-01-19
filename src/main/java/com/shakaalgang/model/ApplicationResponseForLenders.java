package com.shakaalgang.model;

import com.shakaalgang.entity.FirmDetailsEntity;
import com.shakaalgang.entity.ProfileDetailsEntity;
import com.shakaalgang.entity.UserEntity;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Data
@Builder(toBuilder = true)
public class ApplicationResponseForLenders {
    private Long applicationId;
    private ProfileDetailsEntity profileDetailsEntity;
    private FirmDetailsEntity firmDetailsEntity;
    private String status;
    private double amount;
    private int tenure;
    private double interestRate;
    private double outstandingLoanAmount;
    private boolean riskyProfile;
}
