package com.example.recruit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.recruit.jdbc.company.CompanyDto;
import com.example.recruit.jdbc.job.JobDto;
import com.example.recruit.service.CompanyService;
import com.example.recruit.service.ResumeService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ComController {
	
	@Autowired
	CompanyService companyService;
	@Autowired
	ResumeService resumeService;
	
	@GetMapping("/company/main")
	public String printJobList(Model model, HttpServletRequest request) {
	    System.out.println("printJobList() active...");
	    HttpSession session = request.getSession();
	    
	    // 2. 로그인할 때 세션에 저장했던 정확한 이름표("loginCompany")로 꺼내기!
	    CompanyDto dto = (CompanyDto) session.getAttribute("loginCompany");
	    
	    // 안전장치: 혹시라도 로그인 안 하고 주소창에 직접 쳐서 들어온 경우 튕겨내기
	    if (dto == null) {
	        System.out.println("로그인 정보 없음! 로그인 페이지로 쫓아냅니다.");
	        return "redirect:/login"; // 로그인 페이지 주소에 맞게 수정해주세요
	    }
	    
	    // 3. 해당 기업이 올린 공고 목록만 모델에 담기
	    model.addAttribute("jobList", companyService.jobList(dto.getCid()));
	    
	    // 4. 기업 이름도 JSP에서 쓰기 편하게 모델에 바로 담아주기
	    model.addAttribute("companyName", dto.getCname()); 
	    
	    return "company/main";
	}
	
	@GetMapping("/company/detail")
	public String showdetails(Model model, @RequestParam("jno") int jno) {
	    model.addAttribute("job", companyService.getJobDetail(jno));
	    model.addAttribute("resumeList", resumeService.getResumeList(jno));
	    
	    return "company/detail"; 
	}
	
	@GetMapping("/company/write")
	public String writeForm(HttpServletRequest request) {
	    HttpSession session = request.getSession();
	    if (session.getAttribute("loginCompany") == null) {
	        return "redirect:/login";
	    }
	    return "company/write"; 
	}

	@PostMapping("/company/write")
	public String writeProcess(JobDto jobDto, HttpServletRequest request) {
	    HttpSession session = request.getSession();
	    
	    CompanyDto loginCompany = (CompanyDto) session.getAttribute("loginCompany");
	    
	    if (loginCompany != null) {
	        jobDto.setCid(loginCompany.getCid());
	        companyService.writeJob(jobDto);
	    }
	    
	    return "redirect:/company/main";
	}
}
