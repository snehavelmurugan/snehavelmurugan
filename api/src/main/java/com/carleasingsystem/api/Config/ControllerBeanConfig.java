package com.carleasingsystem.api.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.carleasingsystem.api.Controllers.AuthenticationController;
import com.carleasingsystem.api.Controllers.ReservationController;
import com.carleasingsystem.api.Controllers.UserController;

@Configuration
public class ControllerBeanConfig 
{
    @Bean
    public AuthenticationController authenticationController()
    {
        return new AuthenticationController();
    }

    @Bean
    public ReservationController reservationController()
    {
        return new ReservationController();
    }

    @Bean
    public UserController userController()
    {
        return new UserController();
    }
}