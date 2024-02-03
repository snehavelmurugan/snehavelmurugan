package com.carleasingsystem.api.Service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carleasingsystem.api.Entities.Reservation;
import com.carleasingsystem.api.Repositories.ReservationRepository;

import java.util.List;

@Service
public class ReservationService implements ReservationInterface 
{
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() 
    {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(Long id) 
    {
        return reservationRepository.findById(id).orElse(null);
    }

    public Reservation createReservation(Reservation reservation) 
    {
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

	@Override
	public Reservation saveJpa(Reservation reservation) {
		
		return reservationRepository.save(reservation);
	}

	@Override
	public List<Reservation> getJpa() {
		// TODO Auto-generated method stub
		return reservationRepository.findAll();
	}

	@Override
	public Reservation getJpaById(Long id) {
		
		return reservationRepository.findById(id).get();
	}

	@Override
	public Reservation updateJpa(Long id, Reservation reservation) {
		Reservation actres = reservationRepository.findById(id).get();
		BeanUtils.copyProperties(id,actres);
		return reservationRepository.save(actres);
	}

	@Override
	public String deleteJpaById(Long id) {
		reservationRepository.deleteById(id);
		return "Record Deleted Successfully";
	}
}