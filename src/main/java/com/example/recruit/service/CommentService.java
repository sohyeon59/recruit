package com.example.recruit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.recruit.jdbc.job.CommentDto;
import com.example.recruit.jdbc.job.CommentList;
import com.example.recruit.jdbc.job.ICommentDao;

@Service
public class CommentService {
	
	@Autowired
	ICommentDao comDao;
	
	
	// 댓글 등록, 수정, 삭제
	public int insertComment(CommentDto dto) {
		return comDao.insertComment(dto);
	}
	
	public int updateComment(CommentDto dto) {
		return comDao.updateComment(dto);
	}
	
	public int deleteResume(int rno) {
		return comDao.deleteComment(rno);
	}

	// 댓글 리스트 불러오기
	public List<CommentList> getComList(String mid){
		return comDao.getComList(mid);
	}
}
