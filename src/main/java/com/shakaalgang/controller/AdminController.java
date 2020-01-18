package com.shakaalgang.controller;

import com.shakaalgang.entity.ProfileDetailsEntity;
import com.shakaalgang.service.AdminService;
import com.shakaalgang.utils.Constants;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class AdminController {

	private final AdminService adminService;

	AdminController(AdminService adminService){
		this.adminService = adminService;
	}

	@GetMapping({ "/kyc-list" })
	public List<ProfileDetailsEntity> getKycList(@RequestParam Long userId) {
		return adminService.getKycList(userId);
	}

	@PutMapping({ "/update-kyc-status" })
	public Constants.STATUS updateKycStatus(@RequestParam Long userId, @RequestParam String kycStatus) {
		return adminService.updateKycStatus(userId, kycStatus);
	}



}
