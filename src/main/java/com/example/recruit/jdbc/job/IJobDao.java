package com.example.recruit.jdbc.job;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IJobDao {
	
	List<JobDto> list();
	List<JobDto> jobList(@Param("cid") String cid);
	JobDto getJobDetail(int jno);
	
	//구인 공고 작성
	public int writeJob(JobDto dto);
	
	//구인 공고 수정
	public void updateJob(JobDto jobDto);
}
