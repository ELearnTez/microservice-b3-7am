package com.yuvintech.spring.boot.mobile.service;

import java.util.List;

import com.yuvintech.msk.common.dto.FilterDto;
import com.yuvintech.msk.common.dto.MobileDto;
import com.yuvintech.msk.common.dto.Response;
import com.yuvintech.msk.common.dto.SaveMobileDto;


public interface MobileService {

	public Response<List<MobileDto>> getAllMobiles(FilterDto filterDto);

	public  Response<MobileDto> getMobileById(int mobileId);

	public Response<List<MobileDto>> saveMobile(SaveMobileDto saveMobieDto);

	public Response<MobileDto> updateMobile(MobileDto mobile, int mobileId);

	public Response<Void> deleteMobile(int mobileId);
	
	public void saveMobileVoid(SaveMobileDto dto);
	
}
