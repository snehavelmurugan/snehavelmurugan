package com.carleasingsystem.api.Controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.carleasingsystem.api.Entities.VehicleManagment;
import com.carleasingsystem.api.Repositories.VehicleRepository;
import com.carleasingsystem.api.Service.VehicleService;

@CrossOrigin
@RestController
@RequestMapping("cls/vehicle")
public class VehicleController {
	@Autowired
	VehicleRepository vehicleRepo;
	@Autowired
	VehicleService vehicleService;
	
	
//	@PostMapping
//	public VehicleManagment saveVehicle(@RequestBody VehicleManagment stud) {
//		/* return studRepo.save(stud); */
//		return vehicleService.saveVehicle(stud);
//	}
	
	@GetMapping
	public List<VehicleManagment> getVehicle() {
		return vehicleService.getVehicle();
	}
	
//	@GetMapping("/{id}")
//	public VehicleManagment getVehicleId(@PathVariable("id") Integer id) {
//		
//		
//		return  vehicleService.getVehicleId(id);
//	}
	@PutMapping("/{id}")
	public VehicleManagment updateVehicle(@PathVariable("id") Integer id, @RequestBody VehicleManagment stud) {
		System.out.println(stud);
		return vehicleService.updateVeghicle(id, stud);
	}

	@DeleteMapping("/{id}")
	public String deleteVehicle(@PathVariable("id") Integer id) {
		return vehicleService.deleteVehicle(id);
	}

	@PostMapping

	public ResponseEntity<String> submitCarForm(

			@RequestParam("file") MultipartFile file,

			@ModelAttribute VehicleManagment vehicle) throws IOException {

		vehicle.setImage(file.getBytes());

		vehicleService.saveCarform(vehicle);

		return ResponseEntity.ok("");

	}

//	@PostMapping("/carregister")
//
//	    public ResponseEntity<String> submitCarForm(
//
//	            @RequestParam("file") MultipartFile file,
//
//	            @ModelAttribute VehicleManagment vehicle) throws IOException {
//
//	 
//
//	        // Save the image data to the 'image' field in your entity
//
//	    	vehicle.setImage(file.getBytes());
//
//	 
//
//	        // Save the carRegisterForm entity (you need to implement this in your service)
//
//	        vehicleService.saveCarForm(vehicle);
//
//	 
//
//	        return ResponseEntity.ok("");
//
//	    }
//
//	
//	@GetMapping("/{vin}")
//
//	public String getImage(@PathVariable Integer vin, HttpServletResponse response) throws IOException {
//
//		return vehicleService.getImage(vin,response);
//
//	}
	
	 @GetMapping("/{id}")
	    public ResponseEntity<VehicleManagment> getVehicleById(@PathVariable int id) {
	        VehicleManagment vehicle = vehicleService.getVehicleById(id);

	        if (vehicle == null) {
	            return ResponseEntity.notFound().build();
	        }

	        return ResponseEntity.ok(vehicle);
	    }	
	
	
	
//	  @PostMapping("/{vin}/upload-image")
//    public VehicleManagment uploadImage(@PathVariable Integer vin, @RequestParam("image") MultipartFile imageFile) {
//        try {
//            byte[] imageBytes = imageFile.getBytes();
//            return vehicleService.uploadImage(vin, imageBytes);
//        } catch (IOException e) {
//            // Handle the exception (e.g., return an error response)
//            return null;
//        }
//    }

// @PostMapping("/{vin}/upload-image")
//    public ResponseEntity<String> uploadImage(
//            @PathVariable Integer vin,
//            @RequestParam("image") MultipartFile imageFile) {
//
//        try {
//            byte[] imageBytes = imageFile.getBytes();
//            if (vehicleService.uploadImage(vin, imageBytes)) {
//                return ResponseEntity.ok("Image uploaded successfully.");
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehicle not found.");
//            }
//        } catch (IOException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading image.");
//        }
//    }

//@PostMapping
//public ResponseEntity<VehicleManagment> createVehicle( @RequestParam String made,
//		@RequestParam String model, @RequestParam int year, @RequestParam Integer lease_price,
//		@RequestParam("image") MultipartFile file) {
//
//	// Create a VehicleManagment object using the request parameters
//	VehicleManagment vehicle = new VehicleManagment();
//	
//	vehicle.setMade(made);
//	vehicle.setModel(model);
//	vehicle.setYear(year);
//	vehicle.setLease_price(lease_price);
//
//	try {
//		// Convert the MultipartFile to a byte array and set it as the image
//		if (file != null && !file.isEmpty()) {
//			vehicle.setImage(file.getBytes());
//		}
//	} catch (IOException e) {
//		// Handle the exception if needed
//		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//
//	// Save the vehicle to the repository
//	VehicleManagment savedVehicle = vehicleRepo.save(vehicle);
//	return new ResponseEntity<>(savedVehicle, HttpStatus.CREATED);
//}

//@GetMapping("/{vin}")
//public ResponseEntity<VehicleManagment> getVehicleByVin(@PathVariable Integer vin) {
//    // Retrieve the vehicle by VIN from the repository
//    VehicleManagment vehicle = vehicleRepo.findByVin(vin);
//
//    if (vehicle != null) {
//        return new ResponseEntity<>(vehicle, HttpStatus.OK);
//    } else {
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }


//
	 

	
	
}
