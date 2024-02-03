package com.carleasingsystem.api.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.carleasingsystem.api.Entities.User;

@Configuration
public class EntityBeanConfig 
{
    @Bean
    public User User()
    {
        return new User();
    }
}
