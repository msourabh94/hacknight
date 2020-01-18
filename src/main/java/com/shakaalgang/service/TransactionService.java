package com.shakaalgang.service;

import com.shakaalgang.entity.ApplicationDetailsEntity;
import com.shakaalgang.entity.TransactionDetailsEntity;
import com.shakaalgang.repository.ApplicationRepository;
import com.shakaalgang.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    TransactionService(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }


    public List<TransactionDetailsEntity> getTransactionListForLenders(Long lenderId){
        return transactionRepository.findAllByLenderId(lenderId);
    }

    public List<TransactionDetailsEntity> getTransactionListForBorrowers(Long borrowerId){
        return transactionRepository.findAllByBorrowerId(borrowerId);
    }

    public TransactionDetailsEntity registerTransaction(TransactionDetailsEntity transactionDetailsEntity){
        return transactionRepository.save(transactionDetailsEntity);
    }
}
