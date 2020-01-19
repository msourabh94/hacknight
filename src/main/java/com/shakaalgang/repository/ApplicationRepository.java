package com.shakaalgang.repository;

import com.shakaalgang.entity.ApplicationDetailsEntity;
import com.shakaalgang.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<ApplicationDetailsEntity, Long> {

    List<ApplicationDetailsEntity> findAllByBorrowerId(@Param("borrower_id") Long borrowerId);

    List<ApplicationDetailsEntity> findAllByLenderId(@Param("lender_id") Long lenderId);/*

    @Query("update application_details set status = ?1 where id = ?2")
    int updateApplicationStatus(String kycStatus, Long applicationId);*/

}
