package com.yuvintech.mobile.service.functional.hanlder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import com.yuvintech.mobile.service.functional.data.Mobile;
import com.yuvintech.mobile.service.functional.data.Student;
import com.yuvintech.mobile.service.functional.service.MobileService;

@Component
public class MobileHandlerFunctionalEndpoint {
	
	@Autowired
	private MobileService mobileService;

	
	public ServerResponse sayHello(ServerRequest serverRequest) {
		return ServerResponse.ok().body("Hey This is Fuctional EndPoint...!");		
	}
	
	public ServerResponse studentXmlData(ServerRequest serverRequest) {
		
		Student yuvin =  Student.builder().id(1).name("Yuvin").build();
		
		return  ServerResponse.ok().contentType(MediaType.APPLICATION_XML).body(yuvin);
	}
	
     public ServerResponse studentJsonData(ServerRequest serverRequest) {
		
		Student yuvin = Student.builder().id(1).name("Yuvin").build();
		
		return  ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(yuvin);
	}
     
     
     public ServerResponse getAllMobiles(ServerRequest request){
    	 
    	 
    	 List<Mobile> allMobiles =  mobileService.getAllMobiles();
    	 
    	 
    	 return ServerResponse.ok().body(allMobiles);
    	 
     }
     
     public ServerResponse getAllMobileById(ServerRequest request) {
    	 
    	 int mobileId = Integer.parseInt(request.pathVariable("id"));
    	 
    	 
    	 Mobile mobile = mobileService.getMobileById(mobileId);
    	 
    	 return ServerResponse.ok().body(mobile);
    	 
     }
     
     
     public ServerResponse saveMobile(ServerRequest request	) throws ServletException, IOException, URISyntaxException {
    	 Mobile mobile = request.body(Mobile.class);
    	 
    	List<Mobile> allMobiles = mobileService.saveMobile(mobile);
    	
    	URI uri = new URI("http://localhost:8080/mobiles/"+mobile.getId());
    	
    	return ServerResponse.created(uri).body(allMobiles);
    	 
    	 
     }
     
     
	
	// serverRequest -> ServerResponse.ok().body("Hey Friend Welcome to Functional EndPoint Demo..!")
	
	
}
