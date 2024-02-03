package com.carleasingsystem.api.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.carleasingsystem.api.Entities.VehicleManagment;

import jakarta.servlet.http.HttpServletResponse;

@Service
public interface VehicleService {

	

	VehicleManagment saveVehicle(VehicleManagment stud);

	List<VehicleManagment> getVehicle();

	String getVehicleId(Integer id);

	VehicleManagment updateVeghicle(Integer id, VehicleManagment stud);

	String deleteVehicle(Integer id);

	VehicleManagment uploadImage(Integer vin, byte[] imageBytes);

	



	String getImage(@PathVariable Integer vin, HttpServletResponse response) throws IOException;

//	void saveCarform( VehicleManagment vehicle);

	void saveCarform(VehicleManagment vehicle);

	VehicleManagment getVehicleById(int id);

	void submitCarForm(VehicleManagment vehicle);

//	ResponseEntity<String> saveCarform(MultipartFile file, VehicleManagment vehicle) throws IOException;

//	void saveCarForm(VehicleManagment vehicle);

//	void saveCarform(MultipartFile file, VehicleManagment vehicle);

//	ResponseEntity<String> saveCarform(MultipartFile file, VehicleManagment vehicle);

}
