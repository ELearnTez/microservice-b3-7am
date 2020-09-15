package com.yuvintech.spring.boot.mobile.actuator;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class MobileServiceInfo implements InfoContributor{

	@Override
	public void contribute(Builder builder) {
		builder
		.withDetail("info","Mobile Service Core Application . Which provides Mobile Data..!");
	}

}
