package com.carleasingsystem.api.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

import com.carleasingsystem.api.Config.ConfigConstants;

@Entity
@Table(name = ConfigConstants.RESERVATION_TABLE)
public class Reservation 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long CarId;
    private int CustomerId;
    private int ReservationId;
    private String status;
    private LocalDate pickupDate;
    private LocalDate returnDate;
    
    public Reservation()
    {   }
    
	public Reservation(long carId, int customerId, int reservationId, String status, LocalDate pickupDate,
			LocalDate returnDate) 
	{
		super();
		CarId = carId;
		CustomerId = customerId;
		ReservationId = reservationId;
		this.status = status;
		this.pickupDate = pickupDate;
		this.returnDate = returnDate;
	}

	public long getCarId() {
		return CarId;
	}

	public void setCarId(long carId) {
		CarId = carId;
	}

	public int getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}

	public int getReservationId() {
		return ReservationId;
	}

	public void setReservationId(int reservationId) {
		ReservationId = reservationId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(LocalDate pickupDate) {
		this.pickupDate = pickupDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
}