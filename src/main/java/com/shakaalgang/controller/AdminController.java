package com.shakaalgang.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
public class AdminController {

	@GetMapping({ "/kycList" })
	public String hello() {
		return "Hello World";
	}



}
