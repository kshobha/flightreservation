package com.shobha.flightreservation.services;

import org.springframework.stereotype.Component;

import com.shobha.flightreservation.dto.ReservationRequest;
import com.shobha.flightreservation.entities.Reservation;


public interface ReservationService {

	public Reservation bookFlight(ReservationRequest request);
}
