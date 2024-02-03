package com.carleasingsystem.api.Config;

import java.util.Properties;
import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class UtilityBeanConfig 
{
    @Bean
    public Random random()
    {
        return new Random();
    }

    @Bean
    public StringBuffer stringBuffer()
    {
        return new StringBuffer();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() 
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JavaMailSender getJavaMailSender() 
    {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(ConfigConstants.EMAIL_SMTP_SERVER);
        mailSender.setPort(ConfigConstants.EMAIL_SMTP_PORT);
        
        mailSender.setUsername(ConfigConstants.EMAIL);
        mailSender.setPassword(ConfigConstants.EMAIL_APP_PASSWD);
        
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        
        return mailSender;
    }
}