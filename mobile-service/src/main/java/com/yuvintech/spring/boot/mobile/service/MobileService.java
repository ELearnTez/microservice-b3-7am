package com.yuvintech.spring.boot.mobile.service;

import java.util.List;

import com.yuvintech.spring.boot.mobile.service.data.Mobile;

public interface MobileService {

	public List<Mobile> getAllMobiles();

	public Mobile getMobileById(int mobileId);

	public List<Mobile> saveMobile(Mobile mobile);

	public Mobile updateMobile(Mobile mobile, int mobileId);

	public void deleteMobile(int mobileId);
}
