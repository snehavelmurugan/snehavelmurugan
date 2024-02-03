package com.carleasingsystem.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.carleasingsystem.api.Config.ConfigConstants;
import com.carleasingsystem.api.Entities.Email;
import com.carleasingsystem.api.Entities.User;

@Component
public class EmailService implements EmailInterface
{
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private UtilityService utilityService;

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Override
    public String sendEmail(String to)
    {
        String randomPassword = utilityService.generateRandomPassword();

        if(!to.matches(ConfigConstants.EMAIL_REGEX))
        {
            return "invalid email";
        }

        User user = userService.getUserByEmail(to);

        if(user == null)
        {
            return "invalid user email";
        }

        String result = sendSimpleEmail(to, randomPassword);

        user.setPassword(bCryptPasswordEncoder.encode(randomPassword));
        userService.saveUser(user);

        return result;
    }

    @Override
    public String sendEmail(Email email)
    {
        try
        {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(ConfigConstants.EMAIL);
            mailMessage.setTo(email.getTo());
            mailMessage.setSubject(email.getSubject());
            mailMessage.setText(email.getText());
            javaMailSender.send(mailMessage);
        }
        catch(Exception e)
        {
            System.err.println("error occured at sendSimpleMail");
            e.printStackTrace();
        }

        return "nothing - sendsimplemail";
    }

    @Override
    public String sendSimpleEmail(String to, String password)
    {
        try
        {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(ConfigConstants.EMAIL);
            mailMessage.setTo(to);
            mailMessage.setSubject(ConfigConstants.EMAIL_SUBJECT);
            mailMessage.setText(ConfigConstants.EMAIL_TEXT + password);
            javaMailSender.send(mailMessage);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return "error sending mail";
        }

        return "email sent.";
    }
}