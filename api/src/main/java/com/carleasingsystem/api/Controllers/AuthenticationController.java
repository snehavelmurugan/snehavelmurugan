package com.carleasingsystem.api.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carleasingsystem.api.Entities.Credential;
import com.carleasingsystem.api.Entities.Response;
import com.carleasingsystem.api.Entities.User;
import com.carleasingsystem.api.Service.AuthenticationService;
import com.carleasingsystem.api.Service.EmailService;

@RestController
@CrossOrigin
@RequestMapping("/cls/auth")
public class AuthenticationController
{
    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/login")
    public ResponseEntity<Response<String>> signin(@RequestBody Credential credential)
    {
        System.out.println(credential);

        Response<String> response = authenticationService.login(credential);

        return new ResponseEntity<Response<String>>(response, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<Response<String>> signup(@RequestBody User user)
    {
        System.out.println(user);

        Response<String> response = authenticationService.signup(user);
        
        return new ResponseEntity<Response<String>>(response, HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> signout(@RequestBody String jwt)
    {
        String result = authenticationService.logout(jwt);

        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    @PostMapping("/sendemail")
    public ResponseEntity<String> sendMail(@RequestBody String to)
    {
        System.out.println(to);

        String result = emailService.sendEmail(to);

        return ResponseEntity.ok(result);
    }
}