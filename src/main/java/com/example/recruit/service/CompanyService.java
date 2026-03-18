package com.example.recruit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.recruit.jdbc.company.CompanyDto;
import com.example.recruit.jdbc.company.ICompanyDao;
import com.example.recruit.jdbc.resume.IResumeDao;
import com.example.recruit.jdbc.resume.ResumeDto;

@Service
public class CompanyService {

	@Autowired
    ICompanyDao companyDao;
    
    @Autowired
    IResumeDao resumeDao;
    
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

	//공고 내의 이력서 리스트를 조회
	public List<ResumeDto> getResumeList(int jno) {
	    return resumeDao.getResumeList(jno); // 이력서 목록을 DAO에 요청
	}
	
	// 새 구인공고 등록
	public int writeJob(JobDto dto) {
	    return jobDao.writeJob(dto);
	}
	
	public void updateJob(JobDto jobDto) {
        jobDao.updateJob(jobDto);
    }
}