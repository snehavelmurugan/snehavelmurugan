package com.carleasingsystem.api.Service;

import com.carleasingsystem.api.Entities.Email;

public interface EmailInterface 
{
    String sendEmail(String to);
    String sendEmail(Email email);

    String sendSimpleEmail(String to, String password);
}