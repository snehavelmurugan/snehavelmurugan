package com.carleasingsystem.api.Filters;

import java.io.IOException;

import org.springframework.http.HttpMethod;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.carleasingsystem.api.Entities.Credential;
import com.carleasingsystem.api.Provider.UserAuthenticationProvider;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UsernamePasswordAuthFilter extends OncePerRequestFilter 
{

    private static final ObjectMapper MAPPER = new ObjectMapper();
 
    private final UserAuthenticationProvider userAuthenticationProvider;
 
    public UsernamePasswordAuthFilter(UserAuthenticationProvider userAuthenticationProvider) 
    {
        this.userAuthenticationProvider = userAuthenticationProvider;
    }
 
    @Override
    protected void doFilterInternal(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            FilterChain filterChain) throws ServletException, IOException 
    {

        if ("/cls/auth/login".equals(httpServletRequest.getServletPath())
                && HttpMethod.POST.matches(httpServletRequest.getMethod())) 
        {
            Credential credential = MAPPER.readValue(httpServletRequest.getInputStream(), Credential.class);
            
            try 
            {
                SecurityContextHolder.getContext().setAuthentication(userAuthenticationProvider.validateCredentials(credential));
            }
            catch (RuntimeException e) 
            {
                SecurityContextHolder.clearContext();
                throw e;
            }
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}