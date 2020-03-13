package com.kishan.todoapi.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
 
@Configuration
@EnableWebSecurity
public class SecurityConfigBasicAuth extends WebSecurityConfigurerAdapter
{
	@Autowired
	CustomAuthenticationProvider customAuthenticationProvider;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception 
    {
        http
         .csrf().disable()
         .authorizeRequests().antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
         					 .anyRequest().authenticated()
         .and()
         .httpBasic();
    }
  
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) 
            throws Exception 
    {
    	auth.authenticationProvider(customAuthenticationProvider);
    	
		/*
		 * auth.inMemoryAuthentication() .withUser("kishan") .password("{noop}test123")
		 */// Add password storage format, for plain text, add {noop}
            
    }
}