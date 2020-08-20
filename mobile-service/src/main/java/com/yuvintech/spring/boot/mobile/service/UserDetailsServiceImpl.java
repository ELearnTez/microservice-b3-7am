package com.yuvintech.spring.boot.mobile.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.yuvintech.msk.common.entity.MobileUserEntity;
import com.yuvintech.spring.boot.mobile.repository.MobileUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private MobileUserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		if(StringUtils.isEmpty(username)) {
			throw new UsernameNotFoundException("User name Should not be Empty ");
		}
		
		Optional<MobileUserEntity> dbUser = repository.findByUsername(username);
		
		dbUser.orElseThrow(() -> new UsernameNotFoundException("User Not Exists on DB "+username));
		
		
		return User
				.builder()
				.username(dbUser.get().getUsername())
				.password(dbUser.get().getPassword())
				.disabled(!dbUser.get().getActive())
				.roles(dbUser.get().getRoles())
				.build();
		
	}

}
