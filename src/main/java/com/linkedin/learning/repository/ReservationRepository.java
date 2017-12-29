package com.linkedin.learning.repository;

import org.springframework.data.repository.CrudRepository;

import com.linkedin.learning.entity.ReservationEntity;

public interface ReservationRepository extends CrudRepository<ReservationEntity, Long>{

}
