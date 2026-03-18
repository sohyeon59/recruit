package com.example.recruit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.recruit.jdbc.company.CompanyDto;
import com.example.recruit.jdbc.job.JobDto;
import com.example.recruit.service.JobService;
import com.example.recruit.service.ResumeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ComController {

	@Autowired
	ResumeService resumeService;
	@Autowired
	JobService jobService;

	// 기업 메인 - 내 공고 목록
	@GetMapping("/company/main")
	public String printJobList(Model model, HttpSession session) {
		CompanyDto dto = (CompanyDto) session.getAttribute("loginCompany");
		if (dto == null) {
			session.setAttribute("alertMsg", "로그인이 필요한 서비스입니다.");
			return "redirect:/loginForm";
		}
		model.addAttribute("jobList", jobService.jobList(dto.getCid()));
		model.addAttribute("companyName", dto.getCname());
		return "company/main";
	}

	// 공고 상세 - 지원자 목록
	@GetMapping("/company/detail")
	public String showdetails(Model model, @RequestParam("jno") int jno, HttpSession session) {
		if (session.getAttribute("loginCompany") == null) {
			session.setAttribute("alertMsg", "로그인이 필요한 서비스입니다.");
			return "redirect:/loginForm";
		}
		model.addAttribute("job", jobService.getJobDetail(jno));
		model.addAttribute("resumeList", resumeService.getResumeList(jno));
		return "company/detail";
	}

	// 공고 작성 폼
	@GetMapping("/company/write")
	public String writeForm(HttpSession session) {
		if (session.getAttribute("loginCompany") == null) {
			session.setAttribute("alertMsg", "로그인이 필요한 서비스입니다.");
			return "redirect:/loginForm";
		}
		return "company/write";
	}

	// 공고 등록
	@PostMapping("/company/write")
	public String writeProcess(JobDto jobDto, HttpSession session) {
		CompanyDto loginCompany = (CompanyDto) session.getAttribute("loginCompany");
		if (loginCompany == null) {
			session.setAttribute("alertMsg", "로그인이 필요한 서비스입니다.");
			return "redirect:/loginForm";
		}
		jobDto.setCid(loginCompany.getCid());
		jobService.writeJob(jobDto);
		session.setAttribute("alertMsg", "공고가 등록되었습니다.");
		return "redirect:/company/main";
	}
	
	// 공고 수정 화면(Form)
    @GetMapping("/company/editJobForm")
    public String editJobForm(@RequestParam("jno") int jno, Model model) {
        JobDto job = jobService.getJobDetail(jno);
        model.addAttribute("job", job);
        return "company/editJobForm";
    }

	// 공고 수정 폼
	@GetMapping("/company/editJobForm")
	public String editJobForm(@RequestParam("jno") int jno, Model model, HttpSession session) {
		if (session.getAttribute("loginCompany") == null) {
			session.setAttribute("alertMsg", "로그인이 필요한 서비스입니다.");
			return "redirect:/loginForm";
		}
		model.addAttribute("job", jobService.getJobDetail(jno));
		return "company/editJobForm";
	}

	// 공고 수정
	@PostMapping("/company/editJob")
	public String editJob(JobDto jobDto, HttpSession session) {
		if (session.getAttribute("loginCompany") == null) {
			session.setAttribute("alertMsg", "로그인이 필요한 서비스입니다.");
			return "redirect:/loginForm";
		}
		jobService.updateJob(jobDto);
		session.setAttribute("alertMsg", "공고가 수정되었습니다.");
		return "redirect:/company/detail?jno=" + jobDto.getJno();
	}
}
