package com.carleasingsystem.api.Service;

import java.util.List;

import com.carleasingsystem.api.Entities.Reservation;

public interface ReservationInterface 
{
	Reservation saveJpa(Reservation reservation);

	List<Reservation> getJpa();

	Reservation getJpaById(Long id);

	Reservation updateJpa(Long id, Reservation reservation);

	String deleteJpaById(Long id);

}
