package com.example.recruit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.recruit.jdbc.job.JobDto;
import com.example.recruit.jdbc.member.MemberDto;
import com.example.recruit.jdbc.resume.ResumeDetail;
import com.example.recruit.jdbc.resume.ResumeDto;
import com.example.recruit.jdbc.resume.ResumeList;
import com.example.recruit.service.JobService;
import com.example.recruit.service.ResumeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ResController {

	@Autowired
	private ResumeService service;
	@Autowired
	private JobService jobService;

	// 지원서 작성 페이지 이동
	@GetMapping("/goResume")
	public String goResume(@RequestParam("jno")int jno, HttpSession session) {

		// 로그인 체크
		MemberDto mem = (MemberDto) session.getAttribute("loginMember");
		if (mem == null) {
			session.setAttribute("alertMsg", "로그인이 필요한 서비스입니다.");
			return "redirect:/loginForm";
		}

		// 마감일 체크
		JobDto job = jobService.getJobDetail(jno);
		if (job.getDeadline().before(new java.util.Date())) {
			session.setAttribute("alertMsg", "마감된 공고입니다.");
			return "redirect:/";
		}
		return "resume";
	}

	// 지원서 등록
	@PostMapping("/regResume")
	public String regResume(ResumeDto resume, HttpSession session, @RequestParam("jno") int jno) {

		// 로그인 체크
		MemberDto mem = (MemberDto) session.getAttribute("loginMember");
		if (mem == null) {
			session.setAttribute("alertMsg", "로그인이 필요한 서비스입니다.");
			return "redirect:/loginForm";
		}
		// 마감일 체크
		JobDto job = jobService.getJobDetail(jno);
		if (job.getDeadline().before(new java.util.Date())) {
			session.setAttribute("alertMsg", "마감된 공고입니다.");
			return "redirect:/";
		}

		// 중복 지원 체크
		int check = service.checkJNO(mem.getMid(), jno);
		if (check == 0) {
			service.insertResume(resume);
			session.setAttribute("alertMsg", "이력서가 등록되었습니다.");
		} else {
			session.setAttribute("alertMsg", "이미 지원한 공고입니다.");
		}

		return "redirect:/resume/myPage";
	}

	// 지원서 수정
	@PostMapping("/updateResume")
	public String updateResume(ResumeDto resume, HttpSession session) {

		MemberDto mem = (MemberDto) session.getAttribute("loginMember");
		if (mem == null) {
			session.setAttribute("alertMsg", "로그인이 필요한 서비스입니다.");
			return "redirect:/loginForm";
		}
		service.updateResume(resume);
		session.setAttribute("alertMsg", "이력서가 수정되었습니다.");
		return "redirect:/resume/myPage";
	}

	// 지원서 삭제
	@GetMapping("/deleteResume")
	public String deleteResume(@RequestParam("rno") int rno, HttpSession session) {

		MemberDto mem = (MemberDto) session.getAttribute("loginMember");
		if (mem == null) {
			session.setAttribute("alertMsg", "로그인이 필요한 서비스입니다.");
			return "redirect:/loginForm";
		}
		service.deleteResume(rno);
		session.setAttribute("alertMsg", "이력서가 삭제되었습니다.");
		return "redirect:/resume/myPage";
	}

	// 마이페이지 내 지원서 목록
	@GetMapping("/resume/myPage")
	public String myPage(Model model, HttpSession session) {

		MemberDto mem = (MemberDto) session.getAttribute("loginMember");
		if (mem == null) {
			session.setAttribute("alertMsg", "로그인이 필요한 서비스입니다.");
			return "redirect:/loginForm";
		}
		List<ResumeList> rList = service.getMyList(mem.getMid());
		model.addAttribute("resumeList", rList);
		return "/resume/myPage";
	}

	// 내 지원서 상세보기
	@GetMapping("/resumeDetail")
	public String resumeDetail(@RequestParam("rno") int rno, Model model, HttpSession session) {

		MemberDto mem = (MemberDto) session.getAttribute("loginMember");
		if (mem == null) {
			session.setAttribute("alertMsg", "로그인이 필요한 서비스입니다.");
			return "redirect:/loginForm";
		}
		
		
		ResumeDetail detail = service.getMyResume(rno);
		model.addAttribute("detail", detail);
		return "/resume/detail";
	}

	// 지원서 상세보기 (기업용)
	@GetMapping("/company/detailApplicant")
	public String detailApplicant(@RequestParam("rno") int rno, Model model, HttpSession session) {

		if (session.getAttribute("loginCompany") == null) {
			session.setAttribute("alertMsg", "로그인이 필요한 서비스입니다.");
			return "redirect:/loginForm";
		}

		ResumeDetail applicantDetail = service.getApplicantResume(rno);
		model.addAttribute("detail", applicantDetail);
		return "/company/detailApplicant";
	}
}
