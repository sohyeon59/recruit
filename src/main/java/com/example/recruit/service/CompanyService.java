package com.example.recruit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.recruit.jdbc.company.CompanyDto;
import com.example.recruit.jdbc.company.ICompanyDao;
<<<<<<< HEAD
import com.example.recruit.jdbc.job.IJobDao;
=======
>>>>>>> 6003c341df4926d4efe14259d404dee9eb281c69
import com.example.recruit.jdbc.job.JobDto;
import com.example.recruit.jdbc.resume.IResumeDao;
import com.example.recruit.jdbc.resume.ResumeDto;

@Service
public class CompanyService {

	@Autowired
    ICompanyDao companyDao;
    
    @Autowired
    IResumeDao resumeDao;
    
    @Autowired
    IJobDao jobDao;

	// 로그인 - 성공하면 dto 반환, 실패하면 null
	public CompanyDto login(CompanyDto dto) {
		return companyDao.login(dto);
	}

	// 회원가입 - 아이디 중복이면 false
	public boolean regist(CompanyDto dto) {
		if (companyDao.idCheck(dto.getCid()) > 0) return false;
		return companyDao.regist(dto) > 0;
	}

	// 공고 내 지원서 목록 조회
	public List<ResumeDto> getResumeList(int jno) {
		return resumeDao.getResumeList(jno);
	}
}
