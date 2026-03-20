package com.example.recruit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.recruit.jdbc.job.CommentDto;
import com.example.recruit.jdbc.job.CommentList;
import com.example.recruit.service.CommentService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CommentController {
	
	@Autowired
	private CommentService comService;
	
	
	//댓글 작성
	@PostMapping("/insertComment")
	public String insertComment(CommentDto dto,
								HttpSession session) {
		
		String mid = (String) session.getAttribute("mid");
		
		dto.setMid(mid);
		
		comService.insertComment(dto);
	
		return "redirect:/job/detail";
	}
	
	//댓글 수정
	
	
	//댓글 삭제
	
	
	//댓글 리스트
	
	@GetMapping("/commentList")
	public String commentList(@RequestParam("mid")String mid, Model model) {
		
		List<CommentList> cList = comService.getComList(mid);
		model.addAttribute("commentList", cList);
		
		return "/job/detail";
	}
	
	
}
