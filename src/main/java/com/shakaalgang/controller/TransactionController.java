package com.shakaalgang.controller;

import com.shakaalgang.entity.ApplicationDetailsEntity;
import com.shakaalgang.entity.TransactionDetailsEntity;
import com.shakaalgang.service.ApplicationService;
import com.shakaalgang.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping({"/lenders"})
    public List<TransactionDetailsEntity> getTransactionListForLenders(@RequestParam Long lenderId) throws Exception {
        return transactionService.getTransactionListForLenders(lenderId);
    }

    @GetMapping({"/borrowers"})
    public List<TransactionDetailsEntity> getTransactionListForBorrowers(@RequestParam Long borrowerId) throws Exception {
        return transactionService.getTransactionListForBorrowers(borrowerId);
    }

    @PostMapping({"/apply"})
    public TransactionDetailsEntity registerTransaction(@RequestBody TransactionDetailsEntity transactionDetailsEntity) throws Exception {
        return transactionService.registerTransaction(transactionDetailsEntity);
    }

}
