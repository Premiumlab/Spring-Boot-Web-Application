package com.linkedin.learning.rest;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.linkedin.learning.entity.RoomEntity;
import com.linkedin.learning.model.request.ReservationRequest;
import com.linkedin.learning.model.response.ReservationResponse;
import com.linkedin.learning.repository.PageableRoomRepository;
import com.linkedin.learning.repository.RoomRepository;

import convertor.RoomEntityToReservationResponseConverter;

@RestController
@RequestMapping(ResourceConstants.ROOM_RESERVATION_V1)
public class ReservationResource {
	
	@Autowired
	PageableRoomRepository pageableRoomRepository;
	
	@Autowired
	RoomRepository roomRepository;
	
	@RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Page<ReservationResponse> getAvailableRooms(
			@RequestParam(value = "checkin")
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
			LocalDate checkin, 
			@RequestParam(value = "checkout")
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
			LocalDate checkout, Pageable pageable){
		
		Page<RoomEntity> roomEntityList = pageableRoomRepository.findAll(pageable);
		
		
		return roomEntityList.map(new RoomEntityToReservationResponseConverter());
	}
	
	@RequestMapping(path = "/{roomId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<RoomEntity>> getRoomById(
			@PathVariable
			Long roomId) {
		
		List<RoomEntity> roomEntity = roomRepository.findById(roomId);
		
		return new ResponseEntity<>(roomEntity, HttpStatus.OK);
		
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
	
	//push endpoint--update a existing resource. Exactly like post endpoint, except with a different request method.
	//Let's add a new public method called update reservation that returns a response entity that contains a empty reservation response in a 200-okay status code.  
	@RequestMapping(path = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReservationResponse> updateReservation(
			//add a request body annotation to that parameter
			@RequestBody 
			ReservationRequest reservationRequest){
		//return a response entity containing that empty reservation response and the status code created
		return new ResponseEntity<>(new ReservationResponse(), HttpStatus.OK);
	}
	
	//delete endpoint. 
	//public method delete reservation that returns a response entity that contains nobody in a 204 no content status code
	@RequestMapping(path = "/{reservationId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteReservation(
			@PathVariable
			long reservationId){
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
