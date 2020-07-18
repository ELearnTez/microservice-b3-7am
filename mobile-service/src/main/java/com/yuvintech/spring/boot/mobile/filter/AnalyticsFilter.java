package com.yuvintech.spring.boot.mobile.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class AnalyticsFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest hsr = (HttpServletRequest) request;
		String userAgent  = hsr.getHeader("User-Agent");
		System.err.println("RemoteHost : "+ hsr.getRemoteHost());
		
		System.out.println("UserAgent: "+userAgent);
		
		
		
		chain.doFilter(request, response);
		
		
	}
	
	
	

}
