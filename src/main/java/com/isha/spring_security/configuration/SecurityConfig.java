package com.isha.spring_security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;

//This class contains configuration code and bean definitions
@Configuration
// enabling spring security for web applications
@EnableWebSecurity
public class SecurityConfig
{
    //these are the filters
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        // some code here for security features we need

        return http.build();  // Creates the final Security Filter Chain
    }
}
