package com.example.springSecurity.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.springSecurity.dao.SecurityUserDao;
import com.example.springSecurity.entity.SecurityUser;
import lombok.RequiredArgsConstructor;
// @Autowired private SecurityUserDao securityUserDao;		
// member 변수에 바로 넣어주는 것보다 생성자 타입으로 넣어주는 것을 권장 - 이하와 같음
//final type 으로 선언한 것에 대해서 21번째줄을 세팅해주는 컨스트럭터를 만듦

@Service
@RequiredArgsConstructor
public class SecurityUserServiceImpl implements SecurityUserService{
//	private SecurityUserDao securityDao;
//	@Autowired
//	public SecurityUserServiceImpl(SecurityUserDao securityDao) {
//		this.securityDao = securityDao;
//	}
	private final SecurityUserDao securityDao;

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