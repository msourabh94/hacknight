package com.shakaalgang.controller;

import com.shakaalgang.entity.ApplicationDetailsEntity;
import com.shakaalgang.model.ApplicationResponseForLenders;
import com.shakaalgang.service.ApplicationService;
import com.shakaalgang.utils.Constants;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/application")
public class ApplicationController {

    private final ApplicationService applicationService;

    ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping({"/lenders"})
    public List<ApplicationResponseForLenders> getApplicationListForLenders(@RequestParam Long lenderId) throws Exception {
        return applicationService.getApplicationListForLenders(lenderId);
    }

    @GetMapping({"/borrowers"})
    public List<ApplicationDetailsEntity> getApplicationListForBorrowers(@RequestParam Long borrowerId) throws Exception {
        return applicationService.registerApplication(borrowerId);
    }

    @PostMapping({"/apply"})
    public ApplicationDetailsEntity registerApplication(@RequestBody ApplicationDetailsEntity applicationDetailsEntity) throws Exception {
        return applicationService.registerApplication(applicationDetailsEntity);
    }

    @PutMapping({"/update-application-status"})
    public Constants.STATUS updateApplicationStatus(@RequestParam Long applicationId, @RequestParam String applicationStatus) throws Exception {
        return applicationService.updateApplicationStatus(applicationStatus, applicationId);
    }

}
