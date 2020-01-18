package com.shakaalgang.model;

import com.shakaalgang.utils.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationResponse {
	private Constants.STATUS status;
    private String token;
    private UserRegistrationRequest userRegistrationRequest;
}