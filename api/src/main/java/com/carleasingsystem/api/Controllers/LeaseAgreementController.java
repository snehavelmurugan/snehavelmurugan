package com.carleasingsystem.api.Controllers;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carleasingsystem.api.Entities.Customer;
import com.carleasingsystem.api.Service.PdfGenerationService;





@RestController
@RequestMapping("/cls/leaseagreement")
@CrossOrigin
public class LeaseAgreementController {
    @Autowired
    private PdfGenerationService pdfGenerationService;

    @PostMapping("/generate")
    public ResponseEntity<byte[]> generateLeaseAgreement(@RequestBody Customer request) throws IOException {
        byte[] pdfBytes = pdfGenerationService.generatePdf(
            request.getCustomerId(),
            request.getStartDate(),
            request.getEndDate(),
            request.getPayment()
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "lease_agreement.pdf");

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }
}

