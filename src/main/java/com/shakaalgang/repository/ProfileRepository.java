package com.shakaalgang.repository;

import com.shakaalgang.entity.ProfileDetailsEntity;
import com.shakaalgang.entity.UserEntity;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileDetailsEntity, Long> {
}
