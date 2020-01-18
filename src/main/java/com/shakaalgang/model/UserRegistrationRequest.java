package com.shakaalgang.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationRequest {
	private String email;
	private String password;
	private String userType;
	private String firstName;
	private String lastName;
	private Date dob;
	private String fathersName;
	private String pan;
	//private String documentsUrl;
	private String presentAddress;
	private String permAddress;
	private String presentPermSame;
	private double tan;
	private String cin;
	private Date incorpDate;
	private String directorName;
	private Long directorMobileNumber;
	private String firmAddress;
}