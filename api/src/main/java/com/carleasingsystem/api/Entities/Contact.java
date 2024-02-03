package com.carleasingsystem.api.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int contact_id;
	String name;
	String email;
	int phoneno;
	String message;
	public Contact(int contact_id, String name, String email, int phoneno, String message) {
		super();
		this.contact_id = contact_id;
		this.name = name;
		this.email = email;
		this.phoneno = phoneno;
		this.message = message;
	}
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getContact_id() {
		return contact_id;
	}
	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(int phoneno) {
		this.phoneno = phoneno;
	}
	public String getMessage() {
		return message;
	}
	@Override
	public String toString() {
		return "Contact [contact_id=" + contact_id + ", name=" + name + ", email=" + email + ", phoneno=" + phoneno
				+ ", message=" + message + "]";
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

}
