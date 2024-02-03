package com.cls.reservation.ReservationRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cls.reservation.ReservationEntity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    
}