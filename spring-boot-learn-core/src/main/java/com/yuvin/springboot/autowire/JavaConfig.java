package com.yuvin.springboot.autowire;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

@Configuration
public class JavaConfig {
	
	//classic Music
	@Bean
	//@Lazy
	public  Music classicMusic() {
		Music music =  new Music();
		music.setName("classic");
		return music;
	}
	
	
	//westrenMusic
	@Bean
	//@Lazy
	public  Music westrenMusic() {
		Music music =  new Music();
		music.setName("Western");
		return music;
	}
	
	@Bean
	public Decoration decoration() {
		return new Decoration();
	}
	
	
	
	
	
	
}
