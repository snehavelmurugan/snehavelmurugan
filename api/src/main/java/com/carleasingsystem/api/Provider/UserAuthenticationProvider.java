package com.carleasingsystem.api.Provider;

import java.util.Base64;
import java.util.Collections;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.carleasingsystem.api.Entities.Credential;
import com.carleasingsystem.api.Entities.User;
import com.carleasingsystem.api.Service.UserService;

import jakarta.annotation.PostConstruct;

@Component
public class UserAuthenticationProvider 
{ 
    private String secretKey = "sNaKeY";

    // @Autowired
    // private AuthenticationService authenticationService;
    
    @Autowired
    private UserService userService;

    @PostConstruct
    protected void init()
    {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String generateToken(String username)
    {
        User user = userService.getUserByUsername(username);

        user.setToken(createToken(username));

        userService.updateUserByUsername(username, user);

        return user.getToken();
    }

    public String createToken(String username)
    {
        Date now = new Date();

        Date validity = new Date(now.getTime() + 3_600_000); // 1 hour

        Algorithm algorithm = Algorithm.HMAC256(secretKey);//hashed message authentication code 256bit

        String key = JWT.create()
                .withJWTId(username + validity.getTime())
                .withIssuer(username)
                .withIssuedAt(now)
                .withExpiresAt(validity)
                .sign(algorithm);

        return key;
    }

    public Authentication validateToken(String token)
    {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        JWTVerifier verifier = JWT.require(algorithm).build();

        DecodedJWT decodedJWT;
        User user = new User();

        try
        {
            decodedJWT = verifier.verify(token);
            // user = authenticationService.findByLogin(decodedJWT.getIssuer());
        }
        catch(Exception e)
        {
            System.err.println("cannot decode token. maybe expired");
            e.printStackTrace();
        }

        return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
    }

    public String getIssuer(String token)
    {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        JWTVerifier verifier = JWT.require(algorithm).build();

        DecodedJWT decodedJWT;
        String issuer = "";

        try
        {
            decodedJWT = verifier.verify(token);
            issuer = decodedJWT.getIssuer();
        }
        catch(Exception e)
        {
            System.err.println("cannot decode token. maybe expired");
            e.printStackTrace();
        }

        return issuer;
    }

    public void printJwt(DecodedJWT decodedJWT)
    {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("content \t: " + decodedJWT.getContentType() + "\n")
                    .append("headers \t: " + decodedJWT.getHeader() + "\n")
                    .append("id \t\t: " + decodedJWT.getId() + "\n")
                    .append("issuer \t\t: " + decodedJWT.getIssuer() + "\n")
                    .append("signature \t: " + decodedJWT.getSignature() + "\n")
                    .append("claims \t\t: "+ decodedJWT.getClaims() + "\n");

        System.out.println(stringBuffer);
    }

    public boolean isTokenExpired(String token)
    {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        JWTVerifier verifier = JWT.require(algorithm).build();

        try
        {
            DecodedJWT decoded = verifier.verify(token);

            System.out.println(decoded.getClaims());

            if(decoded.getClaim("iat").asLong() >= decoded.getClaim("exp").asLong())
            {
                return true;
            }

            return false;
        }
        catch(Exception e)
        {
            return true;
        }
    }

    public Authentication validateCredentials(Credential credential)
    {
        // User user = authenticationService.authenticateUser(credential);
        return new UsernamePasswordAuthenticationToken(new User(), null, Collections.emptyList());
    }
}