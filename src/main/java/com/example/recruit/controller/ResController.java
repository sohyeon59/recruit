package com.example.recruit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.recruit.jdbc.resume.IResumeDao;
import com.example.recruit.jdbc.resume.ResumeDto;

@Controller
public class ResController {
	
	@Autowired
	private IResumeDao resumeDao;

	//이력서 작성 홈페이지 가기
	@GetMapping("/goResume")
	public String goResume() {
		
		return "";
	}
	
	//이력서 리스트? => 마이페이지
	@GetMapping("/myPage")
	public String resumeList() {
		
		return "";
	}
	
	//이력서 작성하기
	@PostMapping("/regResume")
	public String regResume(ResumeDto resumeDto) {
		resumeDao.insertResume(resumeDto);
		return "redirect:/resumeList";
	}
	
	//이력서 수정
	@PostMapping("/updateResume")
	public String updateresume(ResumeDto resumeDto) {
		resumeDao.updateResume(resumeDto);
		return "";
	}
	
	//이력서 삭제
	@GetMapping("/deleteResume")
	public String deleteResume(@RequestParam("rno")int rno) {
		resumeDao.deleteResume(rno);
		return "";
	}
	
	//전체 이력서 조회
	@GetMapping("/resumeAllList")
	public String getAllList(Model model) {
		model.addAttribute("resumeList", resumeDao.getAllList());
		return "";
	}
	
	//상세보기
	@GetMapping("/resumeDetail")
	public String resumeDetail(@RequestParam("rno")int rno, Model model) {
		model.addAttribute("detail", resumeDao.getDetail(rno));
		return "";
	}
	
	
	//수정 페이지 이동
	@GetMapping("/goEditPage")
	public String goEdit() {
		return "";
	}
	
	
	
	
	
	
	
}
