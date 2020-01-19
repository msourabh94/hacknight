package com.shakaalgang.service;

import com.shakaalgang.entity.ApplicationDetailsEntity;
import com.shakaalgang.entity.TransactionDetailsEntity;
import com.shakaalgang.model.ApplicationResponseForLenders;
import com.shakaalgang.repository.ApplicationRepository;
import com.shakaalgang.repository.FirmRepository;
import com.shakaalgang.repository.ProfileRepository;
import com.shakaalgang.utils.CommonUtils;
import com.shakaalgang.utils.Constants;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final ProfileRepository profileRepository;
    private final FirmRepository firmRepository;
    private final TransactionService transactionService;

    ApplicationService(ApplicationRepository applicationRepository, ProfileRepository profileRepository, FirmRepository firmRepository, TransactionService transactionService) {
        this.applicationRepository = applicationRepository;
        this.profileRepository = profileRepository;
        this.firmRepository = firmRepository;
        this.transactionService = transactionService;
    }


    public List<ApplicationResponseForLenders> getApplicationListForLenders(Long lenderId) {
        List<ApplicationResponseForLenders> responseForLenders = new ArrayList<>();
        List<ApplicationDetailsEntity> applicationDetailsEntityList = applicationRepository.findAllByLenderId(lenderId);
        double totalAppliedLoan = applicationDetailsEntityList.stream()
                .filter(applicationDetailsEntity -> "Y".equalsIgnoreCase(applicationDetailsEntity.getStatus()))
                .mapToDouble(ApplicationDetailsEntity::getAmount).sum();
        applicationDetailsEntityList.stream().forEach(applicationDetailsEntity -> {

                    List<TransactionDetailsEntity> transactionDetailsEntities = transactionService.getTransactionListForBorrowers(applicationDetailsEntity.getBorrowerId());

                    double totalPaidAmount = transactionDetailsEntities.stream()
                            .filter(transactionDetailsEntity -> "D".equalsIgnoreCase(transactionDetailsEntity.getCreditDebitIndicator()))
                            .mapToDouble(TransactionDetailsEntity::getAmountPaid).sum();
                    responseForLenders.add(ApplicationResponseForLenders.builder()
                            .applicationId(applicationDetailsEntity.getId())
                            .tenure(applicationDetailsEntity.getTenure())
                            .interestRate(applicationDetailsEntity.getInterestRate())
                            .amount(applicationDetailsEntity.getAmount())
                            .firmDetailsEntity(firmRepository.findByUserId(applicationDetailsEntity.getBorrowerId()))
                            .profileDetailsEntity(profileRepository.findByUserId(applicationDetailsEntity.getBorrowerId()))
                            .outstandingLoanAmount(totalAppliedLoan - totalPaidAmount)
                            .riskyProfile(CommonUtils.riskProfileCheck(totalAppliedLoan, totalPaidAmount))
                            .status(applicationDetailsEntity.getStatus())
                            .build());
                }
        );
        return responseForLenders;
    }

    public List<ApplicationDetailsEntity> registerApplication(Long borrowerId) {
        return applicationRepository.findAllByBorrowerId(borrowerId);
    }

    public ApplicationDetailsEntity registerApplication(ApplicationDetailsEntity applicationDetailsEntity) {
        return applicationRepository.save(applicationDetailsEntity);
    }

    public Constants.STATUS updateApplicationStatus(String applicationStatus, Long applicationId) {
        Optional<ApplicationDetailsEntity> applicationDetailsEntityOptional = applicationRepository.findById(applicationId);
        if (applicationDetailsEntityOptional.isPresent()) {
            applicationDetailsEntityOptional.get().setStatus(applicationStatus);
            applicationRepository.save(applicationDetailsEntityOptional.get());
            return Constants.STATUS.SUCCESSFULLY_UPDATED;
        } else
            return Constants.STATUS.FAILED_TO_UPDATE;
    }
}
