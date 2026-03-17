package com.example.recruit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.recruit.jdbc.company.CompanyDto;
import com.example.recruit.jdbc.company.ICompanyDao;
import com.example.recruit.jdbc.job.IJobDao;
import com.example.recruit.jdbc.job.JobDto;
import com.example.recruit.jdbc.resume.ResumeDto;

@Service
public class CompanyService {

	@Autowired
	ICompanyDao companyDao;
	IJobDao jobDao;

	// 로그인 - 성공하면 dto 반환, 실패하면 null
	public CompanyDto login(String id, String pw) {
		return companyDao.login(id, pw);
	}

	// 회원가입 - 아이디 중복이면 false
	public boolean regist(CompanyDto dto) {
		if (companyDao.idCheck(dto.getCid()) > 0)
			return false;
		return companyDao.regist(dto) > 0;
	}
	
	public List<JobDto> jobList(String cid) {
		return jobDao.jobList(cid);
	}
	
	public JobDto getJobDetail(int jno) {
	    return jobDao.getJobDetail(jno);
	}

	public List<ResumeDto> getResumeList(int jno) {
	    return jobDao.getResumeList(jno); // 이력서 목록을 DAO에 요청
	}
}