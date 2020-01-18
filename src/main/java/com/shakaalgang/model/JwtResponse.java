package com.shakaalgang.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class JwtResponse{
	private final String jwttoken;
	private final String accountType;
	private final Long userId;
}