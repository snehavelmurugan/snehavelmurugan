package com.carleasingsystem.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.carleasingsystem.api.Entities.Credential;
import com.carleasingsystem.api.Entities.Response;
import com.carleasingsystem.api.Entities.User;
import com.carleasingsystem.api.Provider.UserAuthenticationProvider;

@Service
public class AuthenticationService implements AuthenticationInterface
{
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private UserAuthenticationProvider userAuthenticationProvider;

    public User authenticateUser(Credential credential)
    {
        User user = userService.getUserByUsername(credential.getUsername());

        if(user != null && user.getPassword().equals(bCryptPasswordEncoder.encode(credential.getPassword())))
        {
            return user;
        }

        return null;
    }

    public User findByLogin(String login)
    {
        if ("login".equals(login))
        {
            return new User(1L, "snake", "sneha", "s@s.s", "12345", "password");
        }

        throw new RuntimeException("Invalid login");
    }

    public Response<String> login(Credential credential)
    {
        User user;

        if(credential.getUsername().contains("@"))
        {
            user = userService.getUserByEmail(credential.getUsername());
        }
        else
        {
            user = userService.getUserByUsername(credential.getUsername());
        }

        Response<String> response = new Response<String>();

        System.out.println(user);

        if(user == null)
        {
            response.setStatus_code(1);
            response.setMessage("error");
            response.setT("username not found");
        }
        else if(!bCryptPasswordEncoder.matches(credential.getPassword(), user.getPassword()))
        {
            response.setStatus_code(1);
            response.setMessage("error");
            response.setT("password does not match");
        }
        else if(user.getToken() == null)
        {
            response.setStatus_code(0);
            response.setMessage("token generated");
            response.setT(userAuthenticationProvider.generateToken(user.getUsername()));
            System.out.println("token is null");
        }
        else if(userAuthenticationProvider.isTokenExpired(user.getToken()))
        {
            response.setStatus_code(0);
            response.setMessage("token re-genarated");
            response.setT(userAuthenticationProvider.generateToken(user.getUsername()));
            System.out.println("token expired");
        }
        else
        {
            response.setStatus_code(0);
            response.setMessage("token retrived");
            response.setT(user.getToken());
            System.out.println("token not expired");
        }

        return response;
    }

    public Response<String> signup(User user)
    {
        String message;
        int duplicate_status = userService.isDuplicateEntry(user);

        if(duplicate_status == 0)
        {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userService.saveUser(user);
            System.out.println(user);
            message = "new record added";
        }
        else if(duplicate_status == 1)
        {
            message = "duplicate record found - username";
        }
        else if(duplicate_status == 2)
        {
            message = "duplicate record found - email";
        }
        else
        {
            message = "collatral damage";
        }

        Response<String> response = new Response<String>(duplicate_status, "signup", message);

        return response;
    }

    public String logout(String token)
    {
        SecurityContextHolder.clearContext();
        User user = userService.getUserByUsername(userAuthenticationProvider.getIssuer(token));
        user.setToken(null);
        userService.updateUserById(user.getId(), user);
        return "user updated";
    }
}