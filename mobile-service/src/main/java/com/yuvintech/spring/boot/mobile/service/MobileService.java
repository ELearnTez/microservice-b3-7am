package com.yuvintech.spring.boot.mobile.service;

import java.util.List;

import com.yuvintech.spring.boot.mobile.dto.FilterDto;
import com.yuvintech.spring.boot.mobile.entity.Mobile;

public interface MobileService {

	public List<Mobile> getAllMobiles(FilterDto filterDto);

	public Mobile getMobileById(int mobileId);

	public List<Mobile> saveMobile(Mobile mobile);

	public Mobile updateMobile(Mobile mobile, int mobileId);

	public void deleteMobile(int mobileId);
	
}
