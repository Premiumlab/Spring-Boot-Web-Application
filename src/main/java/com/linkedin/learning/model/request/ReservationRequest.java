package com.linkedin.learning.model.request;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

/*create reservation request, it is a class that represent the request body which is sent during a post*/
public class ReservationRequest {
	private Long id;
	private Long roomId;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate checkin;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate chekout;
		
	public ReservationRequest() {
		super();
	}
	
	public ReservationRequest(Long roomId, LocalDate checkin, LocalDate chekout) {
		super();
		this.roomId = roomId;
		this.checkin = checkin;
		this.chekout = chekout;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
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
