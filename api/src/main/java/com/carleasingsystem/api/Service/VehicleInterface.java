package com.carleasingsystem.api.Service;

import java.util.List;

import com.carleasingsystem.api.Entities.Vehicle;




public interface VehicleInterface {

	

	Vehicle saveVehicle(Vehicle stud);

	List<Vehicle> getVehicle();

	Vehicle getVehicleId(Integer id);

	Vehicle updateVeghicle(Integer id, Vehicle stud);

	String deleteVehicle(Integer id);

}
