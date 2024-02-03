package com.carleasingsystem.api.Config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityBeanConfig 
{ 
    @Autowired
    private UserAuthenticationEntryPoint userAuthenticationEntryPoint;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception 
    {
        http.exceptionHandling(exceptionHandling -> exceptionHandling.authenticationEntryPoint(userAuthenticationEntryPoint))
            // .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .cors(cors -> cors.disable())
            .csrf(csrf -> csrf.disable())
            .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests((authorize) -> authorize.requestMatchers("**")
                                                            .permitAll()
                                                            .anyRequest()
                                                            .authenticated())
            ;
        
        return http.build();
    }

    @Bean
	CorsConfigurationSource corsConfigurationSource() 
    {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("**", configuration);
		return source;
	}
}

// private final UserAuthenticationEntryPoint userAuthenticationEntryPoint;
// private final UserAuthenticationProvider userAuthenticationProvider;

// public SecurityConfig(UserAuthenticationEntryPoint userAuthenticationEntryPoint,
//                       UserAuthenticationProvider userAuthenticationProvider) 
// {
//     this.userAuthenticationEntryPoint = userAuthenticationEntryPoint;
//     this.userAuthenticationProvider = userAuthenticationProvider;
// }