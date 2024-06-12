package com.trade.demo.common;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.JWTVerifier;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

public class JwtFilter implements Filter {
    private List<String> excludedPaths;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        excludedPaths = Arrays.asList("/api/user/register","/api/user/login" );
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String path = request.getRequestURI();

        // Handle OPTIONS requests
        if (RequestMethod.OPTIONS.name().equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return;
        }

        // Allow requests to excluded paths without authentication
        if (excludedPaths.contains(path)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        // Extract and verify JWT token
        String token = request.getHeader("Authorization");
        if (token == null || !token.startsWith("Bearer ")) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized: Missing or invalid token");
            return;
        }

        try {
            // Extract user information from JWT token
            DecodedJWT jwt = JWT.require(Algorithm.HMAC256("secret"))
                    .build()
                    .verify(token.replace("Bearer ", ""));

            // Continue processing the request
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (JWTVerificationException exception) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized: Token verification failed");
        }



    }



}