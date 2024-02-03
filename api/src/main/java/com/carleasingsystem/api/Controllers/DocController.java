package com.carleasingsystem.api.Controllers;

import java.io.IOException;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.carleasingsystem.api.Entities.Doc;
import com.carleasingsystem.api.Repositories.DocRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class DocController {
	
	@Autowired

    private DocRepository docRepository;

	@GetMapping
	public String demo() {
		return "Hello";
	}
	

    @PostMapping("/upload")

    public String uploadSSLCFile(@RequestParam("fileData") MultipartFile file, 
    		                     @RequestParam("fileName") String fileName,
    	                         @RequestParam("fileType") String fileType,
    	                         @RequestParam("uploadedBy") String uploadedBy){
        try {

            // Check if the file is a PDF

            if (file.getContentType() != null && file.getContentType().equals("application/pdf")) {

                Doc docFile = new Doc();

                docFile.setFileName(fileName);
                docFile.setFileType(fileType);
                docFile.setUploadedBy(uploadedBy);
                docFile.setFileData(file.getBytes());

                docRepository.save(docFile);

            } else {

                // Handle invalid file format

            }

        } catch (IOException e) {

            // Handle exception

        }



        return "redirect:/"; // Redirect to a success page or the same page

    }

    

//    @GetMapping("/all")
//    public ResponseEntity<List<Doc>> getAllDocuments() {
//        List<Doc> documents = docRepository.findAll(); // Assuming docRepository is your repository for retrieving documents
//        return new ResponseEntity<>(documents, HttpStatus.OK);
//    }
    
    @GetMapping("/download/{id}")
    public ResponseEntity<ByteArrayResource> downloadDocument(@PathVariable Long id) {
        Optional<Doc> optionalDoc = docRepository.findById(id);
        if (optionalDoc.isPresent()) {
            Doc doc = optionalDoc.get();
            ByteArrayResource resource = new ByteArrayResource(doc.getFileData());

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + doc.getFileName())
                    .contentLength(doc.getFileData().length)
                    .body(resource);
        } else {
            // Handle the case where the document with the given ID is not found
            return ResponseEntity.notFound().build();
        }	
    }
    
    

    
    @GetMapping("/view/{id}")
    public String viewDocument(@PathVariable Long id, Model model) {
        Optional<Doc> optionalDoc = docRepository.findById(id);
        if (optionalDoc.isPresent()) {
            Doc doc = optionalDoc.get();
            // Pass the document data to the view
            model.addAttribute("doc", doc);
            return "view-document"; // Return the name of your view file (e.g., view-document.html)
        } else {
            // Handle the case where the document with the given ID is not found
            return "document-not-found"; // Create a separate HTML view for this case
        }
    }
    
    
   
//    @PutMapping("/update/{id}")
//    public ResponseEntity<String> updateDocument(@PathVariable Long id, @RequestBody Doc updatedDoc) {
//        Optional<Doc> optionalDoc = docRepository.findById(id);
//        if (optionalDoc.isPresent()) {
//            Doc existingDoc = optionalDoc.get();
//            existingDoc.setFileName(updatedDoc.getFileName());
//            existingDoc.setFileData(updatedDoc.getFileData());
//            docRepository.save(existingDoc);
//            
//            return ResponseEntity.ok("Document with ID " + id + " has been updated.");
//        } else {
//            // Handle the case where the document with the given ID is not found
//            return ResponseEntity.notFound().build();
//        }
//    }

    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDocument(@PathVariable Long id) {
        Optional<Doc> optionalDoc = docRepository.findById(id);
        if (optionalDoc.isPresent()) {
            docRepository.deleteById(id);
            return ResponseEntity.ok("Document with ID " + id + " has been deleted.");
        } else {
            // Handle the case where the document with the given ID is not found
            return ResponseEntity.notFound().build();
        }
    }

}


