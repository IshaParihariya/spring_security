package com.isha.spring_security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
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

        http
                // Disables CSRF protection.
                // Used mainly in REST APIs/JWT because they are stateless
                .csrf(customizer->customizer.disable())

                // Defines authorization rules for URLs.
                // Every request requires authentication (login)
                // note : .permitAll() => Allows everyone to access the endpoint.
                .authorizeHttpRequests(request->request.anyRequest().authenticated())

                //Enables HTTP Basic Authentication.
                //Username & password are sent with every request.
                //Customizer.withDefaults() = Use default configuration (no custom changes).
                .httpBasic(Customizer.withDefaults())

                //➡ Configures how Spring manages HTTP Sessions.
                //➡ No HTTP Session (JSESSIONID) is created.
                //➡ Every request must authenticate independently.
                //➡ Commonly used with JWT.
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));


        return http.build();  // Builds and returns the configured Security Filter Chain.
    }
}
