package com.yuvintech.mobile.service.functional.service;

import java.util.List;

import com.yuvintech.mobile.service.functional.data.Mobile;

public interface MobileService {

	public List<Mobile> getAllMobiles();

	public Mobile getMobileById(int mobileId);

	public List<Mobile> saveMobile(Mobile mobile);

	public Mobile updateMobile(Mobile mobile, int mobileId);

	public void deleteMobile(int mobileId);
}
