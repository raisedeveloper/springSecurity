package com.example.springSecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springSecurity.dao.SecurityUserDao;
import com.example.springSecurity.entity.SecurityUser;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor	// 16~20 대체 1
public class SecurityUserServiceImpl implements SecurityUserService {
// private SecurityUserDao securityDao;
// @Autowired
// public SecurityUserServiceImpl(SecurityUserDao securityDao) {
// this.securityDao = securityDao;
// }
	
// 위의 4줄을 14 + 24번이 대체함 member 변수에 바로 넣어주는 것보다 생성자 타입으로 넣어주는 것을 권장 
// final type 으로 선언한 것에 대해서 세팅해주는 컨스트럭터를 만듦
	private final SecurityUserDao securityDao;	// 16~20 대체 2

	@Override
	public SecurityUser getUserByUid(String uid) {
		return securityDao.getUserByUid(uid);
	}

	@Override
	public List<SecurityUser> getSecurityUserList(int page) {
		int count = COUNT_PER_PAGE;
		int offset = (page - 1) * COUNT_PER_PAGE;
		return securityDao.getSecurityUserList(count, offset);
	}

	@Override
	public int getSecurityUserCount() {
		return securityDao.getSecurityUserCount();
	}

	@Override
	public void insertSecurityUser(SecurityUser securityUser) {
		securityDao.insertSecurityUser(securityUser);
	}

	@Override
	public void updateSecurityUser(SecurityUser securityUser) {
		securityDao.updateSecurityUser(securityUser);
	}

	@Override
	public void deleteSecurityUser(String uid) {
		securityDao.deleteSecurityUser(uid);
	}

}