package com.linkedin.learning.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.linkedin.learning.entity.RoomEntity;


public interface RoomRepository extends CrudRepository<RoomEntity, Long> {
	//RoomEntity is an entity we will create to define a room object in our table
	
	List<RoomEntity> findById(Long id);

}
