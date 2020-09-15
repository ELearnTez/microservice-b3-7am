package com.yuvintech.mobile.service.functional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

import com.yuvintech.mobile.service.functional.hanlder.MobileHandlerFunctionalEndpoint;



@SpringBootApplication
public class FunctionalMobileServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FunctionalMobileServiceApplication.class, args);
	}
	
	
	@Bean
	public RouterFunction<ServerResponse> routerFunction(MobileHandlerFunctionalEndpoint mfe){
		
		return RouterFunctions
				.route()
				.GET("/hi", mfe::sayHello)
				.GET("/student", RequestPredicates.accept(MediaType.APPLICATION_XML) , mfe::studentXmlData)
				.GET("/student", RequestPredicates.accept(MediaType.APPLICATION_JSON) , mfe::studentJsonData)
				.GET("/mobiles", mfe::getAllMobiles)
				.GET("/mobiles/{id}",  mfe::getAllMobileById)
				.POST("/mobiles", mfe::saveMobile)
				        .onError(Throwable.class, (th , request) ->  
				        ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
				        .body("Please raise ticket we Will check and get back to you...") )
				.build();
		
		/*return RouterFunctions
				.route()
				.GET("/hi", mfe::sayHello)
				.build();
				
				
		return RouterFunctions
				.route()
				.GET("/hi", request -> mfe.sayHello(request))
				.build();
				
				*/
		
		
		
		
	}

}
