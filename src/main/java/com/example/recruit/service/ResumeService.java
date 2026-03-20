package com.example.recruit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.recruit.jdbc.resume.IResumeDao;
import com.example.recruit.jdbc.resume.ResumeDetail;
import com.example.recruit.jdbc.resume.ResumeDto;
import com.example.recruit.jdbc.resume.ResumeList;

@Service
public class ResumeService {

	@Autowired
	IResumeDao resumeDao;

	// 공고 - 지원서 1:1 확인
	public int checkJNO(String mid, int jno) {
		return resumeDao.checkJNO(mid, jno);
	}

	// 지원서 등록, 수정, 삭제
	public int insertResume(ResumeDto dto) {
		return resumeDao.insertResume(dto);
	}

	public int updateResume(ResumeDto dto) {
		return resumeDao.updateResume(dto);
	}

	public int deleteResume(int rno) {
		return resumeDao.deleteResume(rno);
	}

	// 마이페이지 내 지원서 (페이징)
	public List<ResumeList> getMyList(String mid, int page, int pageSize) {
		int offset = (page - 1) * pageSize;
		return resumeDao.getMyList(mid, offset, pageSize);
	}

	// 마이페이지 내 지원서 총 개수
	public int getMyListCount(String mid) {
		return resumeDao.getMyListCount(mid);

	}
	// 내 지원서 상세보기
	public ResumeDetail getMyResume(int rno) {
		return resumeDao.getMyResume(rno);
	}

	// 공고에 올라온 지원서 확인
	public List<ResumeDto> getResumeList(int jno) {
		return resumeDao.getResumeList(jno);
	}

	// 공고에 올라온 지원서의 세부사항 확인
	public ResumeDetail getApplicantResume(int rno) {
		return resumeDao.getApplicantResume(rno);
	}
}
