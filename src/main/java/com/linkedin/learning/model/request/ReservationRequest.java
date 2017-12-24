package com.linkedin.learning.model.request;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

/*create reservation request, it is a class that represent the request body which is sent during a post*/
public class ReservationRequest {
	private Long id;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate checkin;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate chekout;
		
	public ReservationRequest() {
		super();
	}
	
	public ReservationRequest(Long id, LocalDate checkin, LocalDate chekout) {
		super();
		this.id = id;
		this.checkin = checkin;
		this.chekout = chekout;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getCheckin() {
		return checkin;
	}
	public void setCheckin(LocalDate checkin) {
		this.checkin = checkin;
	}
	public LocalDate getChekout() {
		return chekout;
	}
	public void setChekout(LocalDate chekout) {
		this.chekout = chekout;
	}
	
	

}
