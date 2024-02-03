package com.carleasingsystem.api.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="vehicle_tbl")
public class Vehicle {
	@Id
	@GeneratedValue
	private Integer vin; 
	private String made;
	private String model;
	private int year;
	private Integer lease_price;
	public Vehicle(Integer vin, String made, String model, int year, Integer lease_price) {
		super();
		this.vin = vin;
		this.made = made;
		this.model = model;
		this.year = year;
		this.lease_price = lease_price;
	}
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getVin() {
		return vin;
	}
	public void setVin(Integer vin) {
		this.vin = vin;
	}
	public String getMade() {
		return made;
	}
	public void setMade(String made) {
		this.made = made;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Integer getLease_price() {
		return lease_price;
	}
	public void setLease_price(Integer lease_price) {
		this.lease_price = lease_price;
	}
	@Override
	public String toString() {
		return "VehicleManagment [vin=" + vin + ", made=" + made + ", model=" + model + ", year=" + year
				+ ", lease_price=" + lease_price + "]";
	}
	
	
	

}
