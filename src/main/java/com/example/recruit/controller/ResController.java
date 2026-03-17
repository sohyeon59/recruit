package com.example.recruit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.recruit.jdbc.member.MemberDto;
import com.example.recruit.jdbc.resume.ResumeDto;
import com.example.recruit.jdbc.resume.ResumeList;
import com.example.recruit.service.ResumeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ResController {
	
	@Autowired
	private ResumeService service;
	HttpSession session;

	// 지원서 작성 홈페이지 가기
	@GetMapping("/goResume")
	public String goResume() {		
		return "resume";
	}
	
	// 지원서 등록
	@PostMapping("/regResume")
	public String regResume(ResumeDto resume) {
		int result = service.insertResume(resume);
		session.setAttribute("regResult", result);
		return "redirect:/myPage";
	}
	
	// 지원서 수정
	@PostMapping("/updateResume")
	public String updateresume(ResumeDto resume) {
		int result = service.updateResume(resume);
		session.setAttribute("modResult", result);
		return "redirect:/myPage";
	}
	
	// 지원서 삭제
	@GetMapping("/deleteResume")
	public String deleteResume(@RequestParam("rno")int rno) {
		int result = service.deleteResume(rno);		
		session.setAttribute("delResult", result);
		return "redirect:/myPage";
	}
	
	// 마이페이지 내지원서
	@GetMapping("/myPage")
	public String myPage(Model model) {
		MemberDto mem = (MemberDto) session.getAttribute("loginMember");
		String mid = mem.getMid();
		List<ResumeList> rList = service.getMyList(mid);
		model.addAttribute("resumeList", rList);
		model.addAttribute("result", 1);  // 등록, 수정, 삭제 결과
		return "myPage";
	}
	
	// 내지원서 상세보기
	@GetMapping("/resumeDetail")
	public String resumeDetail(@RequestParam("rno")int rno, Model model) {
		model.addAttribute("detail", service.getMyResume(rno));
		return "";
	}
		
	// 수정 페이지 이동
	@GetMapping("/goEditPage")
	public String goEdit() {
		return "";
	}
	
	
	
	
	
	
	
}
