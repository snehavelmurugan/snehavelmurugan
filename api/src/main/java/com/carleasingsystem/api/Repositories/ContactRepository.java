package com.carleasingsystem.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carleasingsystem.api.Entities.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Integer> {
	

}
