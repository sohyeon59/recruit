package com.example.recruit.jdbc.resume;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IResumeDao {

	void insertResume(ResumeDto resumeDto);
	void updateResume(ResumeDto resumeDto);
	int deleteResume(int rno);
	
	//이력서 전체 보기
	List<ResumeList> getAllList();
	
	//상세보기
	ResumeDto getDetail(int rno);
	
}
