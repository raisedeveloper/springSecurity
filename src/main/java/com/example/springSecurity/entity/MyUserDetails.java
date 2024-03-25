package com.example.springSecurity.entity;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.RequiredArgsConstructor;

// Spring Security가 로그인 POST 요청을 낚아채서 로그인을 진행시키는 코드
// 로컬 로그인 - UserDetails를 구현
// 소셜 로그인 - OAuth2User 구현
@RequiredArgsConstructor		// 생성자방식으로 집어넣어 줌
public class MyUserDetails implements UserDetails{
	private final SecurityUser securityUser;

	// 해당 사용자의 권한을 리턴 - 관리자 or 사용자 인지 구별해 줌
	@Override
	//GrantedAuthority 상속받은 것은 무엇이든 ?에 들어올 수 있음
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collect = new ArrayList<>();
		collect.add(new GrantedAuthority() {
			@Override
			public String getAuthority() {
				return securityUser.getRole();
			}
		});
		return collect;
	}

	@Override
	public String getPassword() {
		return securityUser.getPwd();
	}

	@Override
	public String getUsername() {
		return securityUser.getUid();
	}

	@Override
	public boolean isAccountNonExpired() {
		if (securityUser.getIsDeleted() == 0)
			return true;
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}