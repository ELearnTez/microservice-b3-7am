package com.yuvintech.mobile_accessory.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class RequestTimeLoggingFilter implements WebFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {

		long starttime = System.currentTimeMillis();
		return  chain.filter(exchange)
		 .doOnSuccess(response ->{
			 log.error("The total time taken to process the Request : " + (System.currentTimeMillis() - starttime));
		 })
		 .doOnError(th ->{
			 log.error("Exception details  {} ",th);
			 log.error("The total time taken to process the Request : " + (System.currentTimeMillis() - starttime)); 
		 });

	}

}
