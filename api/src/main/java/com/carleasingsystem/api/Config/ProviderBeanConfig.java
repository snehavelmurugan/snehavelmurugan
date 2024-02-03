package com.carleasingsystem.api.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.carleasingsystem.api.Provider.UserAuthenticationProvider;

@Configuration
public class ProviderBeanConfig 
{
    @Bean
    public UserAuthenticationProvider userAuthenticationProvider()
    {
        return new UserAuthenticationProvider();
    }    
}
