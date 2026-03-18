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

	// 지원서 작성 페이지 가기
	@GetMapping("/goResume")

	public String goResume(int jno, HttpSession session) {

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

	public String regResume(ResumeDto resume, HttpSession session, @RequestParam("jno")int jno) {
		MemberDto mem = (MemberDto) session.getAttribute("loginMember");
		String mid = mem.getMid();
		int check = service.checkJNO(mid, jno);
		if(check == 0) {
			int result = service.insertResume(resume);
			session.setAttribute("regResult", result);
		}else {
			session.setAttribute("regResult", 0);
		}	
		return "redirect:/resume/myPage";
	}

	// 지원서 수정
	@PostMapping("/updateResume")
	public String updateresume(ResumeDto resume, HttpSession session) {
		int result = service.updateResume(resume);
		session.setAttribute("modResult", result);
		return "redirect:/resume/myPage";
	}

	// 지원서 삭제
	@GetMapping("/deleteResume")
	public String deleteResume(@RequestParam("rno") int rno, HttpSession session) {
		int result = service.deleteResume(rno);
		session.setAttribute("delResult", result);
		return "redirect:/resume/myPage";
	}

	// 마이페이지 내지원서
	@GetMapping("/resume/myPage")
	public String myPage(Model model, HttpSession session) {
		MemberDto mem = (MemberDto) session.getAttribute("loginMember");
		if (mem == null) {
			return "redirect:/login";
		}
		String mid = mem.getMid();
		System.out.println(mid);
		List<ResumeList> rList = service.getMyList(mid);
		model.addAttribute("resumeList", rList);
		System.out.println("rList size = " + rList.size());
		return "/resume/myPage";
	}

	// 내지원서 상세보기

	@GetMapping("/resumeDetail")
	public String resumeDetail(@RequestParam("rno") int rno, Model model, HttpSession session) {
		ResumeDetail detail = service.getMyResume(rno);
		model.addAttribute("detail", detail);
		return "/resume/detail";
	}

	// 이력서 조회(기업 회원)
	@GetMapping("/company/detailApplicant")
	public String detailApplicant(@RequestParam("rno") int rno, Model model) {
		ResumeDetail applicantDetail = service.getApplicantResume(rno);
		model.addAttribute("detail", applicantDetail);
		return "/company/detailApplicant";
	}
}
