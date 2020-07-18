package com.yuvintech.spring.boot.mobile.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.yuvintech.spring.boot.mobile.exception.MobileNotFoundException;
import com.yuvintech.spring.boot.mobile.service.data.Mobile;


@Service
public class MobileServiceImpl implements MobileService {
	
	
	List<Mobile> mobiles = new ArrayList<>();

	@Override
	public List<Mobile> getAllMobiles() {
		return mobiles;
	}

	@Override
	public Mobile getMobileById(int mobileId) {
		
	Optional<Mobile>	mobile = mobiles.stream().filter(m -> m.getId() == mobileId).findFirst();
	
	mobile.orElseThrow(() ->  new MobileNotFoundException("Mobile Not Found with given MObile Id"));
	
	return mobile.get();
	
	}

	@Override
	public List<Mobile> saveMobile(Mobile mobile) {
		
		if(!mobiles.contains(mobile)) {
			mobiles.add(mobile);
		}
		
		return getAllMobiles();
	}

	@Override
	public Mobile updateMobile(Mobile mobile, int mobileId) {
		
		Mobile dbmobile = getMobileById(mobileId);
		
		int index = mobiles.indexOf(dbmobile);
		mobiles.set(index, mobile);
		
		return mobile;
	}

	@Override
	public void deleteMobile(int mobileId) {
		Mobile dbmobile = getMobileById(mobileId);
		mobiles.remove(dbmobile);
	}

	@PostConstruct
	public void init() {
		Mobile mobile = new Mobile();
		mobile.setId(1);
		mobile.setName("Samsung");
		mobile.setPrice(10000.00);
		mobile.setStatus("AVAILABLE");
		mobile.setLob("ONLINE");
		mobile.setCountryCode("KOR");
		
		mobiles.add(mobile);
		
		 mobile = new Mobile();
			mobile.setId(2);
			mobile.setName("Samsung");
			mobile.setPrice(10000.00);
			mobile.setStatus("AVAILABLE");
			mobile.setLob("RETAIL");
			mobile.setCountryCode("KOR");
			
			mobiles.add(mobile);
		
	}
}
