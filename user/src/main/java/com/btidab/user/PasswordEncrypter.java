//package com.btidab.user;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//public class PasswordEncrypter {
//	@Bean
//	public PasswordEncoder encode() {
//		return new BCryptPasswordEncoder();
//	}
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//	    return NoOpPasswordEncoder.getInstance(); // Not recommended for production!
//	}
//}
