package com.example.recruit.jdbc.job;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IJobDao {
	
	List<JobDto> list();
	List<JobDto> jobList(@Param("cid") String cid);
	JobDto getJobDetail(int jno);
	public int writeJob(JobDto dto);
}
