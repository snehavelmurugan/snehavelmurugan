package com.carleasingsystem.api.Entities;

import java.util.Arrays;




import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;

import jakarta.persistence.Lob;

@Entity

public class Doc {

	

	    @Id

	    @GeneratedValue(strategy = GenerationType.IDENTITY)

	    private Long id;

	    

	    private String fileName;
	    
	    private String fileType;
	    
	    private String uploadedBy;

	    

	   



		@Lob

	    private byte[] fileData;
		
		
		







		public Doc() {
			super();
			// TODO Auto-generated constructor stub
		}










		public Doc(Long id, String fileName, String fileType, byte[] fileData, String uploadedBy) {
			super();
			this.id = id;
			this.fileName = fileName;
			this.fileType = fileType;
			this.fileData = fileData;
		    this.uploadedBy=uploadedBy;
		}










		public Long getId() {
			return id;
		}










		public void setId(Long id) {
			this.id = id;
		}










		public String getFileName() {
			return fileName;
		}










		public void setFileName(String fileName) {
			this.fileName = fileName;
		}










		public String getFileType() {
			return fileType;
		}










		public void setFileType(String fileType) {
			this.fileType = fileType;
		}










		public byte[] getFileData() {
			return fileData;
		}










		public void setFileData(byte[] fileData) {
			this.fileData = fileData;
		}
		
		










		public String getUploadedBy() {
			return uploadedBy;
		}










		public void setUploadedBy(String uploadedBy) {
			this.uploadedBy = uploadedBy;
		}










		@Override
		public String toString() {
			return "Doc [id=" + id + ", fileName=" + fileName + ", fileType=" + fileType + ", fileData="
					+ Arrays.toString(fileData) + "]";
		}
		
}
		
		

 

		
 