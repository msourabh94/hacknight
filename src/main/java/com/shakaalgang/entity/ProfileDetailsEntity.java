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
@Table(name = "profile_details")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class ProfileDetailsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "dob")
    private Date dob;
    @Column(name = "fathers_name")
    private String fathersName;
    @Column(name = "pan")
    private String pan;
    @Column(name = "kyc_status")
    private String kycStatus;
    @Column(name = "documents_url")
    private String documentsUrl;
    @Column(name = "present_address")
    private String presentAddress;
    @Column(name = "perm_address")
    private String permAddress;
    @Column(name = "present_perm_same")
    private String presentPermSame;
}
