package com.sdczzm.wcmDemo;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private userRepository repository;

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user=repository.findByUsername(username);
		if(user==null){
			throw new UsernameNotFoundException("用户"+username+"不存在");
		}		
		 return new org.springframework.security.core.userdetails.User(username, user.getPassword(),new ArrayList<GrantedAuthority>());
	}

}
