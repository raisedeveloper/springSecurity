package com.example.springSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.http.HttpSession;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean // Bean - 꽂힐 수 있게 주입하는 역할
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// 괄호 안에 람다함수를 사용해야 함 - csrf : 보안과 관련된 부분
		// auth = 매개변수 : x 자리에 auth 를 써준 것 뿐, 아무 의미X
		http.csrf(auth -> auth.disable())	
			.headers(x -> x.frameOptions(y -> y.disable()))		// CK Editor image upload
		;										
		
		return http.build();
	}
}