package com.bbz.spring.demo.config;

import com.bbz.spring.demo.web.filters.LogCostFilter;
import com.bbz.spring.demo.web.filters.LogCostFilter2;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean registFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new LogCostFilter());
        registration.addUrlPatterns("/*");
        registration.setName("LogCostFilter");
        registration.setOrder(100);
        return registration;
    }

    @Bean
    public FilterRegistrationBean registFilter1() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new LogCostFilter2());
        registration.addUrlPatterns("/*");
        registration.setName("LogCostFilter2");
        registration.setOrder(10);
        return registration;
    }

}