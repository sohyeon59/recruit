package com.example.recruit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.recruit.service.CompanyService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ComController {
	
	@Autowired
	CompanyService companyService;

	@GetMapping("/company/login")
	public String login(String id, String pw, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();

//		if (companyService.login(id, pw)) {
//
//			session.setAttribute("cid", id);
//
//			return "redirect:/job/main";
//		} else {
//			model.addAttribute("error", "아이디 또는 비밀번호를 틀리셨습니다.");
//			return "/";
//		}
		return "login";
	}
}
