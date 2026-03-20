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
import com.example.recruit.util.PageHandler;

import jakarta.servlet.http.HttpSession;

@Controller
public class ComController {

	@Autowired
	ResumeService resumeService;
	@Autowired
	JobService jobService;

	// 기업 메인 - 내 공고 목록
	@GetMapping("/company/main")
	public String printJobList(@RequestParam(defaultValue = "1") int page,
							   Model model, HttpSession session) {
		CompanyDto dto = (CompanyDto) session.getAttribute("loginCompany");
		if (dto == null) {
			session.setAttribute("alertMsg", "로그인이 필요한 서비스입니다.");
			return "redirect:/loginForm";
		}
		int pageSize = 10;
		int totalCount = jobService.jobListCount(dto.getCid());
		PageHandler ph = new PageHandler(totalCount, page, pageSize);

		model.addAttribute("jobList", jobService.jobList(dto.getCid(), page, pageSize));
		model.addAttribute("companyName", dto.getCname());
		model.addAttribute("ph", ph);
		model.addAttribute("searchParam", "");
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
