package com.shakaalgang.controller;

import com.shakaalgang.model.UserRegistrationRequest;
import com.shakaalgang.model.UserRegistrationResponse;
import com.shakaalgang.service.ApplicationService;
import com.shakaalgang.utils.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
@RequestMapping("/application")
public class ApplicationController {

    private final ApplicationService applicationService;

    ApplicationController(ApplicationService applicationService){
        this.applicationService = applicationService;
    }

    @PostMapping({"/lenders"})
    public ResponseEntity<?> getApplicationListForLenders(@RequestBody UserRegistrationRequest registrationRequest) throws Exception {
        //return ap
        return  null;
    }


}
