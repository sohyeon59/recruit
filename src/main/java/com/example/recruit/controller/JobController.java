package com.example.recruit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.recruit.jdbc.job.CommentList;
import com.example.recruit.jdbc.job.JobDto;
import com.example.recruit.service.CommentService;
import com.example.recruit.service.JobService;

import jakarta.servlet.http.HttpSession;

@Controller
public class JobController {
	
	@Autowired
	private CommentService comService;
	
	@Autowired
	JobService jobService;

	// 공고 상세
	@GetMapping("/job/detail")
	public String detail(@RequestParam("jno")int jno, HttpSession session, Model model) {

		// 공고 정보
		JobDto job = jobService.getJobDetail(jno);
		model.addAttribute("job", job);

		// 마감일 체크용 오늘 날짜
		model.addAttribute("today", new java.sql.Date(System.currentTimeMillis()));

		// 로그인 여부 (개인회원만 이력서 등록 가능)
		model.addAttribute("isLogin", session.getAttribute("loginMember") != null);
		
		// 댓글 목록
		List<CommentList> cList = comService.getComList(jno);
		model.addAttribute("jno", jno);
		model.addAttribute("commentList", cList);
		
		return "job/detail";
	}
}