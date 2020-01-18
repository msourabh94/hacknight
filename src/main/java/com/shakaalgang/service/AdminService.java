package com.shakaalgang.service;

import com.shakaalgang.entity.ProfileDetailsEntity;
import com.shakaalgang.entity.UserEntity;
import com.shakaalgang.repository.ProfileRepository;
import com.shakaalgang.repository.UserRepository;
import com.shakaalgang.utils.Constants;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;

    AdminService(ProfileRepository profileRepository, UserRepository userRepository) {
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
    }

    public List<ProfileDetailsEntity> getKycList(Long userId) {
        Optional<UserEntity> userObj = userRepository.findById(userId);
        List<ProfileDetailsEntity> profileDetailsEntities = new ArrayList<>();
        if (userObj.isPresent() && userObj.get().getUserType().equalsIgnoreCase(Constants.USER_TYPE_ADMIN)) {
            profileDetailsEntities = profileRepository.findAll();
        }
        return profileDetailsEntities;
    }

    public Constants.STATUS updateKycStatus(Long profileId, String kycStatus) {
        Optional<ProfileDetailsEntity> profileDetailsEntity = profileRepository.findById(profileId);
        if (profileDetailsEntity.isPresent()) {
            profileDetailsEntity.get().setKycStatus(kycStatus);
            profileRepository.save(profileDetailsEntity.get());
            return Constants.STATUS.SUCCESSFULLY_UPDATED;
        }
        else
            return Constants.STATUS.FAILED_TO_UPDATE;
    }


}
