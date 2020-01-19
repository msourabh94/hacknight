package com.shakaalgang.repository;

import com.shakaalgang.entity.ProfileDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileDetailsEntity, Long> {
    ProfileDetailsEntity findByUserId(Long userId);
}
