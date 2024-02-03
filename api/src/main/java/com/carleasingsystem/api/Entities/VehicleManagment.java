package com.carleasingsystem.api.Entities;


import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="vehicle_tbl")
public class VehicleManagment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer vin; 
	private String made;
	private String model;
	private int year;
	private Integer lease_price;
	@Lob
	@Column(columnDefinition="LONGBLOB")
	private byte[] image;
	public VehicleManagment(Integer vin, String made, String model, int year, Integer lease_price, byte[] image) {
		super();
		this.vin = vin;
		this.made = made;
		this.model = model;
		this.year = year;
		this.lease_price = lease_price;
		this.image = image;
	}
	public VehicleManagment() {
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
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "VehicleManagment [vin=" + vin + ", made=" + made + ", model=" + model + ", year=" + year
				+ ", lease_price=" + lease_price + ", image=" + Arrays.toString(image) + "]";
	}
	
	
	
	

}
