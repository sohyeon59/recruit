package com.example.recruit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.recruit.jdbc.job.CommentDto;
import com.example.recruit.jdbc.job.CommentList;
import com.example.recruit.jdbc.job.JobDto;
import com.example.recruit.service.CommentService;
import com.example.recruit.service.JobService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CommentController {
	
	@Autowired
	private CommentService comService;

	//댓글 작성
	@PostMapping("/insertComment")
	public String insertComment(CommentDto dto,	HttpSession session) {
		comService.insertComment(dto);
		session.setAttribute("alertMsg", "댓글이 작성되었습니다");
		return "redirect:/job/detail?jno=" + dto.getJno();
	}
	
	//댓글 수정
	@PostMapping("/updateComment")
	public String updateComment(@RequestParam("content") String content,
								@RequestParam("comno") int comno,
								@RequestParam("jno") int jno,
								HttpSession session) {
		
		comService.updateComment(content, comno);
		session.setAttribute("alertMsg", "댓글이 수정되었습니다.");
		
		return "redirect:/job/detail?jno=" + jno;
	}
	
	
	
	//댓글 삭제
	@RequestMapping("/deleteComment")
	public String deleteComment(@RequestParam("comno") int comno,
								@RequestParam("jno") int jno,
								HttpSession session) {
		
		comService.deleteComment(comno);
		session.setAttribute("alertMsg", "댓글이 삭제되었습니다.");		
		return "redirect:/job/detail?jno=" + jno;
	}
	
	
	

}
