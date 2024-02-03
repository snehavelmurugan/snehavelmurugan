package com.carleasingsystem.api.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.carleasingsystem.api.Service.AuthenticationService;
import com.carleasingsystem.api.Service.EmailService;
import com.carleasingsystem.api.Service.ReservationService;
import com.carleasingsystem.api.Service.UserService;
import com.carleasingsystem.api.Service.UtilityService;

@Configuration
public class ServiceBeanConfig
{
    @Bean
    public AuthenticationService authenticationService()
    {
        return new AuthenticationService();
    }

    @Bean
    public UserService userService()
    {
        return new UserService();
    }

    @Bean
    public ReservationService reservationService()
    {
        return new ReservationService();
    }

    @Bean
    public UtilityService utilityService()
    {
        return new UtilityService();
    }

    @Bean
    public EmailService emailService()
    {
        return new EmailService();
    }

}