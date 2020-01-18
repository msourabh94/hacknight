package com.shakaalgang.controller;

import com.shakaalgang.entity.ProfileDetailsEntity;
import com.shakaalgang.model.UserLoginData;
import com.shakaalgang.service.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class AdminController {

	private final AdminService adminService;

	AdminController(AdminService adminService){
		this.adminService = adminService;
	}

	@GetMapping({ "/kycList" })
	public List<ProfileDetailsEntity> getKycList(@RequestBody String email) {
		return adminService.getKycList(email);
	}



}
