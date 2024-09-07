package com.btidab.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncrypter {
	@Bean
	public PasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}
}
