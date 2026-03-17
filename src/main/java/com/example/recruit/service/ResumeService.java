package com.example.recruit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.recruit.jdbc.resume.IResumeDao;
import com.example.recruit.jdbc.resume.ResumeDto;
import com.example.recruit.jdbc.resume.ResumeList;

@Service
public class ResumeService {

	@Autowired
	IResumeDao resumeDao;
	
	// 지원서 등록, 수정, 삭제 - 성공 1 실패 null
	public int insertResume(ResumeDto dto) {
		return resumeDao.insertResume(dto);
	}
	
	public int updateResume(ResumeDto dto) {
		return resumeDao.updateResume(dto);
	}
	
	public int deleteResume(int rno) {
		return resumeDao.deleteResume(rno);
	}
	
	// 마이페이지 내지원서
	public List<ResumeList> getMyList(String mid){
		return resumeDao.getMyList(mid);
	}
	
	// 내지원서 상세보기
	public ResumeDto getMyResume(int rno) {
		return resumeDao.getMyResume(rno);
	}
	
	
	
	
	
	
}
