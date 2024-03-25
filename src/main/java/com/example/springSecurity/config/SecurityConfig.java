package com.example.springSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.annotation.security.PermitAll;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.http.HttpSession;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean // Bean - 꽂힐 수 있게 주입하는 역할
	// 괄호 안에 람다함수를 사용해야 함 - csrf : 보안과 관련된 부분
	// auth = 매개변수 : x 자리에 auth 를 써준 것 뿐, 아무 의미X
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(auth -> auth.disable())	
			.headers(x -> x.frameOptions(y -> y.disable()))// CK Editor image upload 할 때 필요
			.authorizeHttpRequests(auth -> auth
               .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
               .requestMatchers("/user/register", 
                     "/img/**","/css/**", "/js/**", "/error/**").permitAll() // ** : 모든 파일 엑세스
               .requestMatchers("/admin/**").hasAuthority("ADMIN")
               .anyRequest().authenticated())

			.formLogin(auth -> auth
				.loginPage("/user/login")    // login form 로그인 폼
				.loginProcessingUrl("/user/login")	// 스프링 시큐리티가 낚아 챔. UserDetailsService 구현 객체에서 처리해주어야 함
	            .usernameParameter("uid").passwordParameter("pwd") 
	            // Spring Security에 name/password의 변수 이름을 무엇을 할건지 말해주는 부분   
	            .defaultSuccessUrl("/user/loginSuccess", true)    
	            // 내가 로그인 후 해야할 일 진행 Ex) session setting, 오늘의 명언 등
	            .permitAll()
				
			);										
		
		return http.build();
	}
}