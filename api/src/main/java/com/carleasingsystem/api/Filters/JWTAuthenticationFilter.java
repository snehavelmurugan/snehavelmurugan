// package com.carleasingsystem.api.Filters;

// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.Date;

// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.AuthenticationException;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// import com.auth0.jwt.JWT;
// import com.auth0.jwt.algorithms.Algorithm;
// import com.carleasingsystem.api.Config.SecurityConfigConstants;
// import com.carleasingsystem.api.Entities.User;
// import com.fasterxml.jackson.databind.ObjectMapper;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter
// {
//     private AuthenticationManager authenticationManager;
    
//     public JWTAuthenticationFilter(AuthenticationManager authenticationManager)
//     {
//         this.authenticationManager = authenticationManager;
//         setFilterProcessesUrl("/login");
//     }

//     @Override
//     public Authentication attemptAuthentication(
//                                                     HttpServletRequest request,
//                                                     HttpServletResponse response
//                                                 ) throws AuthenticationException
//     {
//         try
//         {
//             User creds = new ObjectMapper()
//                             .readValue(request.getInputStream(), User.class);

//             return authenticationManager.authenticate(
//                 new UsernamePasswordAuthenticationToken(
//                     creds.getUsername(),
//                     creds.getPassword(),
//                     new ArrayList<>())
//                     );
//         }
//         catch(Exception e)
//         {
//             throw new RuntimeException(e);
//         }
//     }

//     @Override
//     public void successfulAuthentication(
//                                             HttpServletRequest request,
//                                             HttpServletResponse response,
//                                             FilterChain chain,
//                                             Authentication auth
//                                         ) throws IOException
//     {
//         String token = JWT.create()
//                         .withSubject(((User)auth.getPrincipal()).getUsername())
//                         .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConfigConstants.EXPIRATION_TIME))
//                         .sign(Algorithm.HMAC512(SecurityConfigConstants.SECRET.getBytes()));

//         String body = ((User) auth.getPrincipal()).getUsername() + " " + token;

//         response.getWriter().write(body);
//         response.getWriter().flush();
//     }
// }