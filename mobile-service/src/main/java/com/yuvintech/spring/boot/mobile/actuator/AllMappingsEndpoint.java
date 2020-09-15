package com.yuvintech.spring.boot.mobile.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Component
@WebEndpoint(enableByDefault = true, id="all-mappings")
public class AllMappingsEndpoint {

	@Autowired
	private RequestMappingHandlerMapping handlerMapping;
	
	@ReadOperation
	public void getAllEndpointInfo() {
		
		handlerMapping.getHandlerMethods().forEach(( k ,v ) ->{
			
			
			
			System.out.println(k );
			System.out.println(v );
			
		});
		
		
	}
	
}
