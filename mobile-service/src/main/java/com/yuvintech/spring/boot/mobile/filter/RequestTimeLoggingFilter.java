package com.yuvintech.spring.boot.mobile.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RequestTimeLoggingFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// Pre -processing  
		long startTime = System.currentTimeMillis();
		
		chain.doFilter(request, response); // DispatcherServlet -> HandlerAdapter -> Controller -> RequestMapping
		
		log.error("Total Time Taking to process the Requesst :: "+(System.currentTimeMillis() - startTime)+" in MilliSeconds");
		// Post -processing
		
	}
	
}
