package com.carleasingsystem.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carleasingsystem.api.Entities.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> 
{
    
}