package com.yuvintech.spring.boot.methodinjection;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;


@Component
public abstract class Solution2MovieReservation{
	
	@Lookup
	public abstract Seat getSeat(); 

	// Spring creates Proxy with same ApplicationCOntextAware  
	

}
