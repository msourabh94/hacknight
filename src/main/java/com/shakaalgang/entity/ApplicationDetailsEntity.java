package com.shakaalgang.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "application_details")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class ApplicationDetailsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(name = "borrower_id")
    private Long borrowerId;
    @Column(name = "lender_id")
    private Long lenderId;
    @Column(name = "status")
    private String status;
    @Column(name = "amount")
    private double amount;
    @Column(name = "tenure")
    private int tenure;
    @Column(name = "interest_rate")
    private double interestRate;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
    @Column(name = "updated_by")
    private Long updatedBy;
}
