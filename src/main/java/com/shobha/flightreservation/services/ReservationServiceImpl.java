package com.shobha.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.shobha.flightreservation.dto.ReservationRequest;
import com.shobha.flightreservation.entities.Flight;
import com.shobha.flightreservation.entities.Passenger;
import com.shobha.flightreservation.entities.Reservation;
import com.shobha.flightreservation.repos.FlightRepository;
import com.shobha.flightreservation.repos.PassengerRepository;
import com.shobha.flightreservation.repos.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	 ReservationRepository reservationRepository;
	@Autowired
	 PassengerRepository passengerRepository;
	@Autowired
	 FlightRepository flightRepository;

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		Long flightId = request.getFlightId();
		Flight flight = flightRepository.findOne(flightId);

		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());

		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());

		Passenger savedPassenger = passengerRepository.save(passenger);

		Reservation reservation = new Reservation();
		reservation.setFlight(flight);

		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		
		Reservation savedReservation = reservationRepository.save(reservation);

		return savedReservation;
	}

}
