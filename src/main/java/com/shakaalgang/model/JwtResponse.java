package com.shakaalgang.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	private final String accountType;

	public JwtResponse(String jwttoken, String accountType) {
		this.jwttoken = jwttoken;
		this.accountType = accountType;
	}

	public String getToken() {
		return this.jwttoken;
	}
}