package com.example.recruit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.recruit.jdbc.member.MemberDto;
import com.example.recruit.jdbc.resume.ResumeDetail;
import com.example.recruit.jdbc.resume.ResumeDto;
import com.example.recruit.jdbc.resume.ResumeList;
import com.example.recruit.service.ResumeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ResController {
	
	@Autowired
	private ResumeService service;
	@Autowired
	HttpSession session;

	// 지원서 작성 페이지 가기
	@GetMapping("/goResume")
	public String goResume() {		
		MemberDto mem = (MemberDto) session.getAttribute("loginMember");
		//		System.out.println(mem);
//		session.setAttribute("mem", mem);
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
		return "myPage";
	}
	
	// 내지원서 상세보기
	@GetMapping("/resumeDetail")
	public String resumeDetail(@RequestParam("rno")int rno, Model model) {
		ResumeDetail detail = service.getMyResume(rno);
		model.addAttribute("detail", detail);
		return "detail";
	}

	
	
	
	
	
	
	
}
