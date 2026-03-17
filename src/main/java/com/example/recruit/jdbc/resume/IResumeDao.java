package com.example.recruit.jdbc.resume;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IResumeDao {

	int insertResume(ResumeDto resumeDto);
	int updateResume(ResumeDto resumeDto);
	int deleteResume(@Param("rno") int rno);
	
	// 이력서 전체 보기
	List<ResumeList> getMyList(@Param("mid") String mid);
	
	// 상세보기
	ResumeDto getMyResume(@Param("rno") int rno);
	
	// 상세보기(기업용)
	List<ResumeDto> getResumeList(int jno);
}
