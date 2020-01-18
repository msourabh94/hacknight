package com.shakaalgang.service;

import com.shakaalgang.entity.FirmDetailsEntity;
import com.shakaalgang.entity.ProfileDetailsEntity;
import com.shakaalgang.entity.UserEntity;
import com.shakaalgang.model.UserLoginData;
import com.shakaalgang.model.UserRegistrationRequest;
import com.shakaalgang.repository.FirmRepository;
import com.shakaalgang.repository.ProfileRepository;
import com.shakaalgang.repository.UserRepository;
import com.shakaalgang.utils.CommonUtils;
import com.shakaalgang.utils.Constants;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final FirmRepository firmRepository;

    RegisterService(UserRepository userRepository, ProfileRepository profileRepository, FirmRepository firmRepository) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
        this.firmRepository = firmRepository;
    }

    /**
     * This method will be used to register user. Password will be encrypted using Bcrypt.
     * @param registrationRequest
     * @return Status of registration
     */
    public Constants.STATUS registerUser(UserRegistrationRequest registrationRequest) {
        boolean userExists = userRepository.findByEmail(registrationRequest.getEmail()).isPresent();
        if (!userExists) {
            UserEntity createdUserEntity = userRepository.save(
                    UserEntity.builder()
                    .email(registrationRequest.getEmail())
                    .password(CommonUtils.passwordEncoder().encode(registrationRequest.getPassword()))
                    .build()
            );
            ProfileDetailsEntity profileDetailsEntity = ProfileDetailsEntity.builder()
                    .userId(createdUserEntity.getId())
                    .dob(registrationRequest.getDob())
                    .fathersName(registrationRequest.getFathersName())
                    .firstName(registrationRequest.getFirstName())
                    .lastName(registrationRequest.getLastName())
                    .pan(registrationRequest.getPan())
                    .permAddress(registrationRequest.getPermAddress())
                    .presentAddress(registrationRequest.getPresentAddress())
                    .presentPermSame(registrationRequest.getPresentPermSame())
                    .build();
            profileRepository.save(profileDetailsEntity);

            FirmDetailsEntity firmDetailsEntity = FirmDetailsEntity.builder()
                    .userId(createdUserEntity.getId())
                    .firmAddress(registrationRequest.getFirmAddress())
                    .cin(registrationRequest.getCin())
                    .directorMobileNumber(registrationRequest.getDirectorMobileNumber())
                    .directorName(registrationRequest.getDirectorName())
                    .createdBy(createdUserEntity.getId())
                    .incorpDate(registrationRequest.getIncorpDate())
                    .tan(registrationRequest.getTan())
                    .updatedBy(createdUserEntity.getId())
                    .build();

            firmRepository.save(firmDetailsEntity);

            return Constants.STATUS.SUCCESSFULLY_REGISTERED;
        } else {
            return Constants.STATUS.USERNAME_EXISTS;
        }
    }


}