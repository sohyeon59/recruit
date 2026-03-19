package com.example.recruit.jdbc.job;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ICommentDao {
	
	// 댓글 등록, 수정, 삭제
	int insertComment(CommentDto commentDto);
	int updateComment(CommentDto commentDto);
	int deleteComment(@Param("cno") int cno);

}
