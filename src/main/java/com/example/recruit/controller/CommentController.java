package com.example.recruit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.recruit.jdbc.job.CommentDto;
import com.example.recruit.jdbc.member.MemberDto;
import com.example.recruit.service.CommentService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CommentController {
	
	@Autowired
	private CommentService comService;

	//댓글 작성
	@PostMapping("/insertComment")
	public String insertComment(CommentDto dto,	HttpSession session) {
		
		MemberDto mem = (MemberDto) session.getAttribute("loginMember");
		if (mem == null) {
			session.setAttribute("alertMsg", "로그인이 필요한 서비스입니다.");
			return "redirect:/loginForm";
		}
		
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
