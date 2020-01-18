package com.shakaalgang.repository;

import com.shakaalgang.entity.FirmDetailsEntity;
import com.shakaalgang.entity.ProfileDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirmRepository extends JpaRepository<FirmDetailsEntity, Long> {
}
