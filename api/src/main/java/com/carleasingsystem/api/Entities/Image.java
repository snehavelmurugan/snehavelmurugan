package com.carleasingsystem.api.Entities;

import java.util.Arrays;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Image {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String filename;
    private String description;

    @Lob
    private byte[] data;

	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Image(Long id, String filename, String description, byte[] data) {
		super();
		this.id = id;
		this.filename = filename;
		this.description = description;
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ImageManagment [id=" + id + ", filename=" + filename + ", description=" + description + ", data="
				+ Arrays.toString(data) + "]";
	}
    
}
