package com.example.recruit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.recruit.jdbc.member.IMemberDao;
import com.example.recruit.jdbc.member.MemberDto;

@Service
public class MemberService {

	@Autowired
	IMemberDao memberDao;

	// 로그인 - 성공하면 dto 반환, 실패하면 null
	public MemberDto login(MemberDto dto) {
		return memberDao.login(dto);
	}

	// 회원가입 - 아이디 중복이면 false
	public boolean regist(MemberDto dto) {
		if (memberDao.idCheck(dto.getMid()) > 0)
			return false;
		return memberDao.regist(dto) > 0;
	}
}