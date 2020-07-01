package com.yuvin.springboot.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class WesternMarriage {
	
	@Autowired
	@Qualifier("westrenMusic")
	private Music music;
	
	@Autowired // Required
	private Decoration decoration;
	
	@Autowired(required = false)
	private Catering  catering;// If it available . If 
	
	
	public Music getMusic() {
		return music;
	}

	
	public Decoration getDecoration() {
		return decoration;
	}


	public void setMusic(Music music) {
		this.music = music;
	}


	public void setDecoration(Decoration decoration) {
		this.decoration = decoration;
	}
	
	
	
	
	
}
