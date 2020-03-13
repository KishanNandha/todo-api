package com.kishan.todoapi.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.kishan.todoapi.todos.beans.UserBean;
import com.kishan.todoapi.users.repos.UserRepo;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();

		if (shouldAuthenticateAgainstThirdPartySystem(username,password)) {

			// use the credentials
			// and authenticate against the third-party system
			//List list=Arrays.asList("USER")
			return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
		} else {
			return null;
		}
	}
	
	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
	private boolean shouldAuthenticateAgainstThirdPartySystem(String username, String password) {
		UserBean user = userRepo.findByUserNameAndUserPassword(username, password);
		if(null != user) {
			return true;
		}
		return false;
	}


}
