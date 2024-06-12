package com.trade.demo.config;

import com.trade.demo.common.JwtFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<JwtFilter> registrationBean() {
        FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new JwtFilter());
//        registrationBean.addUrlPatterns("/emps/*", "/manages/*", "/medicines/*",
//                "/customers/*","/database/*" ,"/outIns/*","/sales/*",
//                "/storages/*","/stores/*","/suppliers/*"); // 以此类推
        // 指定过滤器适用的URL模式

        return registrationBean;
    }
}
