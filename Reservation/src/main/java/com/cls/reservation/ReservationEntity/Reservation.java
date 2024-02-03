package com.cls.reservation.ReservationEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long CarId;
    private int CustomerId;
    private int ReservationId;
    private String status;
    private String customerName;
    private LocalDate pickupDate;
    private LocalDate returnDate;
    
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

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

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Reservation(long carId, int customerId, int reservationId, String status, String customerName,
			LocalDate pickupDate, LocalDate returnDate, Car car) {
		super();
		CarId = carId;
		CustomerId = customerId;
		ReservationId = reservationId;
		this.status = status;
		this.customerName = customerName;
		this.pickupDate = pickupDate;
		this.returnDate = returnDate;
		this.car = car;
	}

    
}
