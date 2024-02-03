package com.carleasingsystem.api.Controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carleasingsystem.api.Entities.Contact;
import com.carleasingsystem.api.Repositories.ContactRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin
@RestController
@RequestMapping("/api/contact")
public class ContactController {
//	@Autowired
	@Autowired
	ContactRepository contactRepo;
	
	@PostMapping
	public Contact saveContact(@RequestBody Contact con) {
		return contactRepo.save(con);
	}
//	
	
	@GetMapping
	public List<Contact> getContact() {
		return contactRepo.findAll();
	}
	
	
	@GetMapping("/{id}")
	public Contact getContact1(@PathVariable("id") Integer contactid) {
		/* return studRepo.findById(studid).get(); */
		return contactRepo.findById(contactid).get();
	}
	@PutMapping("/{id}")
	public Contact updateContact(@PathVariable("id") Integer contactid,@RequestBody Contact con) {
		Contact actCon =contactRepo.findById(contactid).get();
		BeanUtils.copyProperties(con, actCon);
		return contactRepo.save(actCon);
	}
//	
	@DeleteMapping("/{id}")
	public String deleteContact(@PathVariable("id") Integer contactid ) {
		contactRepo.deleteById(contactid);
		return "deleted the Contact with given id";
	}
//	

}
