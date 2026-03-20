package com.example.recruit.jdbc.job;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IJobDao {

	// 전체 공고 목록 (페이징 + 검색 + 정렬)
	List<JobDto> list(@Param("offset") int offset, @Param("pageSize") int pageSize,
					  @Param("cat") String cat, @Param("searchText") String searchText,
					  @Param("startDate") String startDate, @Param("endDate") String endDate,
					  @Param("sort") String sort, @Param("order") String order);

	// 전체 공고 수 (검색 포함)
	int totalCount(@Param("cat") String cat, @Param("searchText") String searchText,
				   @Param("startDate") String startDate, @Param("endDate") String endDate);

	// 기업별 공고 목록 (페이징)
	List<JobDto> jobList(@Param("cid") String cid, @Param("offset") int offset, @Param("pageSize") int pageSize);

	// 기업별 공고 수
	int jobListCount(@Param("cid") String cid);

	// 공고 상세
	JobDto getJobDetail(int jno);

	// 공고 등록
	public int writeJob(JobDto dto);

	// 공고 수정
	public void updateJob(JobDto jobDto);
}
