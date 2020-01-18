package com.shakaalgang.controller;

import com.shakaalgang.model.JwtResponse;
import com.shakaalgang.model.UserLoginData;
import com.shakaalgang.model.UserRegistrationRequest;
import com.shakaalgang.model.UserRegistrationResponse;
import com.shakaalgang.service.RegisterService;
import com.shakaalgang.service.UserAuthService;
import com.shakaalgang.utils.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {


    private final RegisterService registerService;
    private final UserAuthService userAuthService;


    UserController(
            RegisterService registerService,
            UserAuthService userAuthService
    ) {
        this.registerService = registerService;
        this.userAuthService = userAuthService;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody UserLoginData authenticationRequest)
            throws Exception {
        return ResponseEntity.ok(userAuthService.authenticateAndGenerateToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));
    }


    @PostMapping({"/register"})
    public ResponseEntity<?> register(@RequestBody UserRegistrationRequest registrationRequest) throws Exception {
        Constants.STATUS registrationStatus = registerService.registerUser(registrationRequest);
        if (registrationStatus.equals(Constants.STATUS.SUCCESSFULLY_REGISTERED)) {
            String token = userAuthService.authenticateAndGenerateToken(registrationRequest.getEmail(), registrationRequest.getPassword()).getJwttoken();
            return new ResponseEntity<>(UserRegistrationResponse.builder().status(registrationStatus).token(token).userRegistrationRequest(registrationRequest).build(), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(UserRegistrationResponse.builder().status(registrationStatus).build(), HttpStatus.CONFLICT);
        }
    }

}
