package com.example.recruit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.recruit.jdbc.company.CompanyDto;
import com.example.recruit.jdbc.job.JobDto;
import com.example.recruit.jdbc.resume.ResumeDto;
import com.example.recruit.service.CompanyService;
import com.example.recruit.service.ResumeService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ComController {
	
	@Autowired
	CompanyService companyService;
	ResumeService resumeService;
	
	@PostMapping("/")
	public String printJobList(Model model, HttpServletRequest request) {
	    HttpSession session = request.getSession();
	    
	    // 1. 세션에서 로그인한 기업 정보 가져오기
	    CompanyDto dto = (CompanyDto) session.getAttribute("CompanyDto");
	    
	    // 2. 해당 기업이 올린 공고 목록만 모델에 담기
	    model.addAttribute("jobList", companyService.jobList(dto.getCid()));
	    
	    // 3. 기업 이름도 JSP에서 쓰기 편하게 모델에 바로 담아주기 (DB 조회 불필요!)
	    model.addAttribute("companyName", dto.getCname()); 
	    
	    return "company/main";
	}
	
	@GetMapping("/company/detail")
	public String showdetails(Model model, int jno) {
		model.addAttribute("job", companyService.getJobDetail(jno));
		model.addAttribute("resumeList", resumeService.getResumeList(jno));
		return "company/detail"; 
	}
}
