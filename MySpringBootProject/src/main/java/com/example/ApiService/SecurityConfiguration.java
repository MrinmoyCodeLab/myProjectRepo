package com.example.ApiService;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration  
@EnableGlobalMethodSecurity(prePostEnabled = true) 
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	

	@Override
	 protected void configure(final HttpSecurity http) throws Exception {  
        http.authorizeRequests()  
            .antMatchers("/**").permitAll()  
            .anyRequest().authenticated()
            .and().formLogin();  
    } 

}

 
