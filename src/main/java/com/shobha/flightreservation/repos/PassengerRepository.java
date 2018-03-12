package com.shobha.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shobha.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
