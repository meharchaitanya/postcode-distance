package com.mehar.postcode.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/distance").permitAll() // Allow access to /distance endpoint
                .anyRequest().authenticated() // Secure all other endpoints
                .and()
                .csrf().disable(); // Disable CSRF for simplicity (not recommended for production)
    }
}