package com.example.recruit.jdbc.resume;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IResumeDao {
	
	void insertResume(ResumeDto resumeDto);
	
	void deleteResume(ResumeDto resumeDto);
	
	void unpdateResume(ResumeDto resumeDto);
	void deleteResume(int rno);
	
}
