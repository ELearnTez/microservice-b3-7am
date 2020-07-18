package com.yuvintech.spring.boot.mobile.config;

import javax.servlet.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.yuvintech.spring.boot.mobile.filter.AnalyticsFilter;
import com.yuvintech.spring.boot.mobile.filter.RequestTimeLoggingFilter;


@Configuration
public class FilterConfiguration {
	
	
	@Bean
	public FilterRegistrationBean<Filter>  configurationFilter(){
		 FilterRegistrationBean<Filter>  frb = new FilterRegistrationBean<Filter> ();
		 frb.setFilter(requestTimeLoggingFilter());
		 frb.setFilter(analyticsFilter());
		 frb.addUrlPatterns("/*");
		 return frb;
	}
	
	@Bean
	@Order(value = 1)
	public RequestTimeLoggingFilter requestTimeLoggingFilter() {
		System.out.println("--------");
		return new RequestTimeLoggingFilter();
	}
	
	
	@Bean
	@Order(value = 2)
	public AnalyticsFilter analyticsFilter() {
		return new AnalyticsFilter();
	}

}
