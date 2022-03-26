package br.casaaposta.main.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return null;
		
	//	com.bootstrap.springboot.model.User user = userService.getByEmail(email);
		
	//	if (user.getEmail().equals(email)) {
	//		return new User(email, user.getPassword(),
		//			new ArrayList<>());
		//} else {
		//	throw new UsernameNotFoundException("User not found with email: " + email);
		}
	}



