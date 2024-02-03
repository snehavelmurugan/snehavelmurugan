package com.carleasingsystem.api.Service;

import java.io.IOException;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.carleasingsystem.api.Entities.VehicleManagment;
import com.carleasingsystem.api.Repositories.VehicleRepository;

import jakarta.servlet.http.HttpServletResponse;


@Service
public class VehicleServiceImpl implements VehicleService{
	@Autowired
	VehicleRepository vehicleRepo;

	@Override
	public VehicleManagment saveVehicle(VehicleManagment stud) {
		// TODO Auto-generated method stub
		return vehicleRepo.save(stud);
	}

	@Override
	public List<VehicleManagment> getVehicle() {
		// TODO Auto-generated method stub
		return vehicleRepo.findAll();
	}

//	@Override
//	public VehicleManagment getVehicleId(Integer id) {
//		// TODO Auto-generated method stub
//		return vehicleRepo.findById(id).get();
//	}

	@Override
	public VehicleManagment updateVeghicle(Integer id, VehicleManagment stud) {
		// TODO Auto-generated method stub
		VehicleManagment actStud =vehicleRepo.findById(id).get();
		BeanUtils.copyProperties(stud, actStud);
		return vehicleRepo.save(actStud);
	}

	@Override
	public String deleteVehicle(Integer id) {
		// TODO Auto-generated method stub
		vehicleRepo.deleteById(id);
		return "deleted the vehicle with given vehicle_id";
	}

	@Override
	public VehicleManagment uploadImage(Integer vin, byte[] imageBytes) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public void saveCarform(VehicleManagment vehicle) {
//		// TODO Auto-generated method stub
//		vehicleRepo.save(vehicle);
//		
//	}

	@Override
	public String getVehicleId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public String getImage(@PathVariable Integer vin, HttpServletResponse response) throws IOException {
		VehicleManagment vehicle = vehicleRepo.findByVin(vin);

		if (vehicle != null && vehicle.getImage() != null) {

			response.setContentType("image/jpeg"); // Set the content type to image/jpeg or your image format

			response.getOutputStream().write(vehicle.getImage());

			response.getOutputStream().flush();

		} else {

			response.setStatus(HttpServletResponse.SC_NOT_FOUND);

		}
//		return vehicleRepo.findById(vin).get();
		return "Got Vehicle";
	}
//
//	@Override
//	public ResponseEntity<String> saveCarform(MultipartFile file, VehicleManagment vehicle) throws IOException {
//		vehicle.setImage(file.getBytes());
//		return ResponseEntity.ok("");
//	}
//	@Override
//	public void saveCarForm(VehicleManagment vehicle) {
//	vehicleRepo.save(vehicle);
//		
//	}

	@Override
	public void saveCarform(VehicleManagment vehicle) {
		// TODO Auto-generated method stub
		vehicleRepo.save(vehicle);
		
	}

	@Override
	public VehicleManagment getVehicleById(int id) {
		// TODO Auto-generated meth
//		return vehicleRepo.findByVin(id);
		 Optional<VehicleManagment> optionalVehicle = vehicleRepo.findById(id);
	        
	        return optionalVehicle.orElse(null);
	}

	@Override
	public void submitCarForm(VehicleManagment vehicle) {
		vehicleRepo.save(vehicle);
		
	}

//	@Override
//	public void saveCarForm(VehicleManagment vehicle) {
//		vehicleRepo.save(vehicle);
//		
//	}

//	@Override
//	public void saveCarform(MultipartFile file, VehicleManagment vehicle) {
//		// TODO Auto-generated method stub
//		vehicleRepo.save(vehicle);
//	}
//
//	@Override
////	public void saveCarForm(VehicleManagment vehicle) {
//
//		// TODO Auto-generated method stub
//
////		
////	}



//	@Override
//	public void saveCarForm(VehicleManagment vehicle) {
//		// TODO Auto-generated method stub
//		vehicleRepo.save(vehicle);
//		
//	}

	


//	@Override
//	public void saveCarForm(VehicleManagment vehicle) {
//		// TODO Auto-generated method stub
//		
//	}

//	@Override
//	public ResponseEntity<String> submitCarForm() {
//		vehicle.setImage(file.getBytes());
//		vehicleService.saveCarform(vehicle);
//
//		return ResponseEntity.ok("");
//	}

//	@Override
//	public VehicleManagment uploadImage(Integer vin, byte[] imageBytes) {
//		 VehicleManagment vehicle = vehicleRepo.findById(vin).orElse(null);
//	        if (vehicle != null) {
//	            vehicle.setImage(image);
//	            return vehicleRepo.save(vehicle);
//	        }
//	        return null;
//	}
//
//	 @PostMapping("/{vin}/upload-image")
//	   public VehicleManagment uploadImage(@PathVariable Integer vin, @RequestBody byte[] image) {
//	       try {
//	           VehicleManagment vehicle = vehicleService.uploadImage(vin, image);
//	           if (vehicle != null) {
//	               return new ResponseEntity<>(vehicle, HttpStatus.OK);
//	           } else {
//	               return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	           }
//	       } catch (Exception e) {
//	           // Handle the exception (e.g., return an error response)
//	           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//	       }
//	   }
//	
	
}
