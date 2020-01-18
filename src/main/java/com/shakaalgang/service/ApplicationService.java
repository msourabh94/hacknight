package com.shakaalgang.service;

import com.shakaalgang.entity.ApplicationDetailsEntity;
import com.shakaalgang.repository.ApplicationRepository;
import com.shakaalgang.utils.Constants;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;

    ApplicationService(ApplicationRepository applicationRepository){
        this.applicationRepository = applicationRepository;
    }


    public List<ApplicationDetailsEntity> getApplicationListForLenders(Long lenderId){
        return applicationRepository.findAllByLenderId(lenderId);
    }

    public List<ApplicationDetailsEntity> registerApplication(Long borrowerId){
        return applicationRepository.findAllByBorrowerId(borrowerId);
    }

    public ApplicationDetailsEntity registerApplication(ApplicationDetailsEntity applicationDetailsEntity){
        return applicationRepository.save(applicationDetailsEntity);
    }

    public Constants.STATUS updateApplicationStatus(String applicationStatus, Long applicationId){
        Optional<ApplicationDetailsEntity> applicationDetailsEntityOptional = applicationRepository.findById(applicationId);
        if(applicationDetailsEntityOptional.isPresent()){
            applicationDetailsEntityOptional.get().setStatus(applicationStatus);
            applicationRepository.save(applicationDetailsEntityOptional.get());
            return Constants.STATUS.SUCCESSFULLY_UPDATED;
        }else
            return Constants.STATUS.FAILED_TO_UPDATE;
    }

}
