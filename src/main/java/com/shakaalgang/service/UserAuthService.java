package com.shakaalgang.service;

import com.shakaalgang.config.JwtTokenUtil;
import com.shakaalgang.entity.UserEntity;
import com.shakaalgang.model.JwtResponse;
import com.shakaalgang.model.UserLoginData;
import com.shakaalgang.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserAuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailsAuthService userDetailsAuthService;
    private final UserRepository userRepository;


    UserAuthService(
            AuthenticationManager authenticationManager,
            JwtTokenUtil jwtTokenUtil,
            UserDetailsAuthService userDetailsAuthService,
            UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsAuthService =userDetailsAuthService;
        this.userRepository = userRepository;
    }

    public JwtResponse authenticateAndGenerateToken(String email, String password) throws Exception {
        UserDetails userDetails = authenticate(email, password);
        return JwtResponse.builder().jwttoken(jwtTokenUtil.generateToken(userDetails)).accountType(userRepository.getOne(email).getUserType()).build();
    }

    /**
     * Authenticate and get user details from DB
     *
     * @param email
     * @param password
     * @return User Details from DB
     * @throws Exception
     */
    private UserDetails authenticate(String email, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
            return userDetailsAuthService.loadUserByUsername(email);

        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }



}
