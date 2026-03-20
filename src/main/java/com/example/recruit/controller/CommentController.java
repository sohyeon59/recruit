package com.example.recruit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class CommentController {
	
	@Autowired
	
	
	
	//댓글 작성
	@PostMapping("/insertComment")
	public String insertComment(@RequestParam("con") int cno,
								@RequestParam("jno") int jno,
								HttpSession session) {
		
		String mid = (String) session.getAttribute("mid");
		
		
		
		
		
		
		return "";
	}
	
	//댓글 수정
	
	
	//댓글 삭제
	
	
	
	
	
	
}
