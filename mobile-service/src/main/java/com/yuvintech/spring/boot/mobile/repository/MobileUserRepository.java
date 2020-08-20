package com.yuvintech.spring.boot.mobile.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yuvintech.msk.common.entity.MobileUserEntity;

public interface MobileUserRepository extends JpaRepository<MobileUserEntity, Integer>{

	Optional<MobileUserEntity> findByUsername(String username);
	
}
