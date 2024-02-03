package com.carleasingsystem.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carleasingsystem.api.Entities.ImageManagment;



public interface ImageRepository extends JpaRepository<ImageManagment,Long>{

}
