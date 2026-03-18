package com.example.recruit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.recruit.jdbc.job.IJobDao;
import com.example.recruit.jdbc.job.JobDto;

@Service
public class JobService {

	@Autowired
	private IJobDao jobDao;

	// 전체 공고 목록 (메인화면용)
	public List<JobDto> list() {
		return jobDao.list();
	}

	// 기업별 공고 목록 (기업 메인용)
	public List<JobDto> jobList(String cid) {
		return jobDao.jobList(cid);
	}

	// 공고 상세
	public JobDto getJobDetail(int jno) {
		return jobDao.getJobDetail(jno);
	}

	// 공고 등록
	public int writeJob(JobDto dto) {
		return jobDao.writeJob(dto);
	}

	// 공고 수정
	public void updateJob(JobDto dto) {
		jobDao.updateJob(dto);
	}
}
