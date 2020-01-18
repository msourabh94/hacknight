package com.shakaalgang.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
public class ApplicationController {

	@GetMapping({ "/" })
	public String hello() {
		return "Hello World";
	}



}
