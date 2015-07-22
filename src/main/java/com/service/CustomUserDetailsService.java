package com.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDAO;

@Service
@Transactional(readOnly=true)
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDAO userDAO;	

	@Override
	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException {
		
		com.model.User domainUser = userDAO.getUser(login);
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		System.out.println("********* " +domainUser.getRole().getId());
		return new User(
				domainUser.getLogin(), 
				domainUser.getPassword(), 
				enabled, 
				accountNonExpired, 
				credentialsNonExpired, 
				accountNonLocked,
				getAuthorities(domainUser.getRole().getId())
		);
	}

	public Collection getAuthorities(Integer role) {
		List authList = getGrantedAuthorities(getRoles(role));
		return authList;
	}

	public List getRoles(Integer role) {

		List roles = new ArrayList();

		if (role.intValue() == 1) {
			roles.add("ROLE_MODERATOR");
			roles.add("ROLE_ADMIN");
		} else if (role.intValue() == 2) {
			roles.add("ROLE_MODERATOR");
		}
		return roles;
	}

	public static List getGrantedAuthorities(List<String> roles) {
		List authorities = new ArrayList();

		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}

	
	public UserDAO getUserDao() {
		return userDAO;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDAO = userDao;
	}


}