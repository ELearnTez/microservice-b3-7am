package com.yuvintech.mobile.client.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.yuvintech.msk.common.dto.MobileDto;
import com.yuvintech.msk.common.dto.Response;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class MobileServiceIntegration {

	@Autowired
	private WebClient mobileServiceClient;

	public Mono<MobileDto> getMobileById(int id) {
		Mono<Response<MobileDto>> monoresponse  = mobileServiceClient
				.get()
				.uri("/{mobile-id}", id)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(new ParameterizedTypeReference<Response<MobileDto>>() {
				});
		
		return monoresponse.map(response -> response.getResponse());
		
	}

	public Flux<MobileDto> getAllMobiles() {

		Mono<Response<List<MobileDto>>> mobileServiceResponse = mobileServiceClient.get()
				.accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(new ParameterizedTypeReference<Response<List<MobileDto>>>() {
				});

		return mobileServiceResponse.flatMap(response -> Mono.just(response.getResponse()))
				.flatMapMany(Flux::fromIterable);

	}

}
