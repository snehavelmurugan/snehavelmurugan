// package com.carleasingsystem.api.Filters;

// import java.io.IOException;
// import java.util.ArrayList;

// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

// import com.auth0.jwt.JWT;
// import com.auth0.jwt.algorithms.Algorithm;
// import com.carleasingsystem.api.Config.SecurityConfigConstants;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// public class JWTAuthroizationFilter extends BasicAuthenticationFilter
// {
//     public JWTAuthroizationFilter(AuthenticationManager authenticationManager)
//     {
//         super(authenticationManager);
//     }

//     @Override
//     protected void doFilterInternal(
//                                         HttpServletRequest request,
//                                         HttpServletResponse response,
//                                         FilterChain chain
//                                     ) throws IOException, ServletException
//     {
//         String header = request.getHeader(SecurityConfigConstants.HEADER_STRING);

//         if(header == null || !header.startsWith(SecurityConfigConstants.TOKEN_PREFIX))
//         {
//             chain.doFilter(request, response);
//             return;
//         }

//         UsernamePasswordAuthenticationToken authentication = getAuthentication(request);

//         SecurityContextHolder.getContext().setAuthentication(authentication);

//         chain.doFilter(request, response);
//     }


//     private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) 
//     {
//         String token = request.getHeader(SecurityConfigConstants.HEADER_STRING);

//         if (token != null) 
//         {
//             String user = JWT.require(Algorithm.HMAC512(SecurityConfigConstants.SECRET.getBytes()))
//                     .build()
//                     .verify(token.replace(SecurityConfigConstants.TOKEN_PREFIX, ""))
//                     .getSubject();

//             if (user != null) 
//             {
//                 return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
//             }

//             return null;
//         }

//         return null;
//     }
// }