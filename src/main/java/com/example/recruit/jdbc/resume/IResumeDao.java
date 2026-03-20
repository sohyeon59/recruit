
package com.example.recruit.jdbc.resume;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IResumeDao {

	// 공고 - 지원서 1:1 확인
	int checkJNO(@Param("mid") String mid, @Param("jno") int jno);
		
	// 지원서 등록, 수정, 삭제
	int insertResume(ResumeDto resumeDto);
	int updateResume(ResumeDto resumeDto);
	int deleteResume(@Param("rno") int rno);
	
	// 지원서 전체 보기 (페이징)
	List<ResumeList> getMyList(@Param("mid") String mid, @Param("offset") int offset, @Param("pageSize") int pageSize);

	// 지원서 총 개수
	int getMyListCount(@Param("mid") String mid);
	
	// 상세보기
	ResumeDetail getMyResume(@Param("rno") int rno);
	
	// 지원서 리스트 보기(기업용)
	List<ResumeDto> getResumeList(int jno);
	
	// 지원서 상세보기(기업용)
	ResumeDetail getApplicantResume(int rno);
}
