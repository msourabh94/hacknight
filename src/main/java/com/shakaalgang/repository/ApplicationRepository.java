package com.shakaalgang.repository;

import com.shakaalgang.entity.ApplicationDetailsEntity;
import com.shakaalgang.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<ApplicationDetailsEntity, Long> {

    List<ApplicationDetailsEntity> findByBorrowerId(Long borrowerId);

    List<ApplicationDetailsEntity> findByLenderId(Long lenderId);

}
