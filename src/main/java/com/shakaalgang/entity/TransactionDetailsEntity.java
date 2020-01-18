package com.shakaalgang.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "transaction_details")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDetailsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(name = "application_id")
    private Long applicationId;
    @Column(name = "amount_paid")
    private double amountPaid;
    @Column(name = "credit_debit_ind")
    private String creditDebitIndicator;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
    @Column(name = "created_by")
    private Long createdBy;
    @Column(name = "updated_by")
    private Long updatedBy;
}
