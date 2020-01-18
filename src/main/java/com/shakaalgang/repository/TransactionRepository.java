package com.shakaalgang.repository;

import com.shakaalgang.entity.ApplicationDetailsEntity;
import com.shakaalgang.entity.TransactionDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionDetailsEntity, Long> {

    String findTxnsForBorrowers = "select t1.*, t2.borrower_id from shakalgang.transaction_details t1, shakalgang.application_details t2 where borrower_id=?1";
    String findTxnsForLenders = "select t1.*, t2.borrower_id from shakalgang.transaction_details t1, shakalgang.application_details t2 where lender_id=?1";

    @Query(value = findTxnsForBorrowers, nativeQuery = true)
    List<TransactionDetailsEntity> findAllByBorrowerId(@Param("borrower_id")Long borrowerId);

    @Query(value = findTxnsForLenders, nativeQuery = true)
    List<TransactionDetailsEntity> findAllByLenderId(Long lenderId);

}
