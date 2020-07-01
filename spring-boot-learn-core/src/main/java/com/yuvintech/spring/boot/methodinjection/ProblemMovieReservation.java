package com.yuvintech.spring.boot.methodinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class ProblemMovieReservation{ // only once

  @Autowired
  private Seat seat;// context.getBean(Seat.class);

	public Seat getSeat() {
		return seat;
	}
	
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	  
  
  
}