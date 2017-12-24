package com.linkedin.learning.rest;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.linkedin.learning.model.request.ReservationRequest;
import com.linkedin.learning.model.response.ReservationResponse;

@RestController
@RequestMapping(ResourceConstants.ROOM_RESERVATION_V1)
public class ReservationResource {
	
	@RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReservationResponse> getAvailableRooms(
			@RequestParam(value = "checkin")
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
			LocalDate checkin, 
			@RequestParam(value = "checkout")
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
			LocalDate checkout){
		
		
		return new ResponseEntity<>(new ReservationResponse(), HttpStatus.OK);
	}
	
	//post endpoint -- create a new resource, i.e. reserve a room
	//let's create a public method called create reservation that returns a response entity that contains an empty reservation response and a 201-created status quote
	//create reservation will take in a parameter called reservation request, which is a request body  
	@RequestMapping(path = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReservationResponse> createReservation(
			//add a request body annotation to that parameter
			@RequestBody 
			ReservationRequest reservationRequest){
		//return a response entity containing that empty reservation response and the status code created
		return new ResponseEntity<>(new ReservationResponse(), HttpStatus.CREATED);
	}
	
	

}
