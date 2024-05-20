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
        excludedPaths = Arrays.asList("/api/user/register");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println(request.toString());
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String path = request.getRequestURI();
        //也是对预处理请求的一些配置
            if(request.getMethod().equals(RequestMethod.OPTIONS.name()))
            {
                response.setStatus(HttpServletResponse.SC_OK);
                //下面的5行不用,注释掉是因为在webconfig里已经配置了,且下方的*,无限制匹配,不安全
//                response.setHeader("Access-Control-Allow-Origin","*");
//                response.setHeader("Access-Control-Allow-Headers","*");
//                response.setHeader("Access-Control-Allow-Methods","*");
//                response.setHeader("Access-Control-Allow-Credentials","true");
//                response.setHeader("Access-Control-Max-Age","3600");
//                response.setStatus(HttpStatus.OK.value());

            }
        // 对预检请求和排除的路径直接放行
        if (request.getMethod().equals("OPTIONS") || excludedPaths.contains(path)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }else{

            // ...

        System.out.println("path  "+path);
//        if (path.equals("/emps/user/login")) {
//            filterChain.doFilter(servletRequest, servletResponse);
//            return;
//        }else if(path.equals("/emps/user/register")) {
//            filterChain.doFilter(servletRequest, servletResponse);
//            return;
//        }
        try {
            String token = request.getHeader("Authorization");
            System.out.println("原始token"+token);
            if (token != null && token.startsWith("Bearer ")) {
                // 提取Token并验证...
                try {
                    // 从Token中提取用户信息等
                    DecodedJWT jwt = JWT.require(Algorithm.HMAC256("secret"))
                            .build()
                            .verify(token.replace("Bearer ", ""));
                    System.out.println(jwt.toString()+"jwt的字符串");
                    // 验证通过，执行下一步
                    filterChain.doFilter(servletRequest, servletResponse);
                } catch (JWTVerificationException exception){
                    System.out.println("catchToken验证失败");
                    // Token验证失败的处理逻辑
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized: Token verification failed");
                }
            } else {
                // Token验证失败的处理逻辑
//            Result errorResult =new Result("401","Token验证失败");
//            response.getWriter().write(new ObjectMapper().writeValueAsString(errorResult));
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized: Token verification failed");
                System.out.println("esle 中的Token验证失败");

                // 没有Token的处理逻辑
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized: Token verification failed");
            }
            // 可以添加更多的catch块来捕获其他潜在异常
        }catch (JWTVerificationException exception) {
            // 捕获JWT验证异常
            System.out.println("JWT异常");
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized: Token verification failed");

        }





        Enumeration<String> params = request.getParameterNames();
        while (params.hasMoreElements()) {
            String paramName = params.nextElement();
            System.out.println(paramName + ": " + request.getParameter(paramName));
        }
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
                stringBuilder.append("");
            }
        } catch (IOException ex) {
            throw ex;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    throw ex;
                }
            }
        }
        String body = stringBuilder.toString();
        System.out.println("Request Body: " + body);
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            Enumeration<String> headers = request.getHeaders(headerName);
            while (headers.hasMoreElements()) {
                String headerValue = headers.nextElement();
                System.out.println(headerName + ": " + headerValue);
            }
        }

        System.out.println("DDDDDDDDDDDDDDDDDDD");


    // 其他方法...

    }

    }

}