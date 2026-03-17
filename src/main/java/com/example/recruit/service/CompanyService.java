package com.example.recruit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.recruit.jdbc.company.CompanyDto;
import com.example.recruit.jdbc.company.ICompanyDao;

@Service
public class CompanyService {

	@Autowired
	ICompanyDao companyDao;

	// 로그인 - 성공하면 dto 반환, 실패하면 null
	public CompanyDto login(CompanyDto dto) {
		return companyDao.login(dto);
	}

	// 회원가입 - 아이디 중복이면 false
	public boolean regist(CompanyDto dto) {
		if (companyDao.idCheck(dto.getCid()) > 0)
			return false;
		return companyDao.regist(dto) > 0;
	}
}