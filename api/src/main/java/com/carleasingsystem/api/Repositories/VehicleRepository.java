package com.carleasingsystem.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.web.multipart.MultipartFile;

import com.carleasingsystem.api.Entities.VehicleManagment;




public interface VehicleRepository extends JpaRepository<VehicleManagment,Integer>{

	VehicleManagment findByVin(Integer vin);

//	void save(MultipartFile file, VehicleManagment vehicle);

	

//	VehicleManagment getVehicleId(Integer vin);

}
