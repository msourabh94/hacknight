package com.shakaalgang.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "firm_details")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class FirmDetailsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "tan")
    private double tan;
    @Column(name = "cin")
    private String cin;
    @Column(name = "incorp_date")
    private Date incorpDate;
    @Column(name = "director_name")
    private String directorName;
    @Column(name = "director_mobile_no")
    private Long directorMobileNumber;
    @Column(name = "firm_address")
    private String firmAddress;
    @Column(name = "updated_at")
    private Date updatedAt;
    @Column(name = "created_by")
    private Long createdBy;
    @Column(name = "updated_by")
    private Long updatedBy;
}
