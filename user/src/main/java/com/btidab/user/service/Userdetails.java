//package com.btidab.user.service;
//
//import java.util.ArrayList;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//	
//import com.btidab.user.entity.User;
//import com.btidab.user.repos.UserLoginRepository;
//
//@Service
//public class Userdetails implements UserDetailsService {
//
//	@Autowired
//	private UserLoginRepository repo;
//
//	@Override
//	public org.springframework.security.core.userdetails.User loadUserByUsername(String Username)
//			throws UsernameNotFoundException {
//		User user = repo.findByUsername(Username);
//		if (user == null) {
//			throw new UsernameNotFoundException("User not found");
//		}
//		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
//				new ArrayList<>());
//	}
//
//}
