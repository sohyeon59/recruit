package com.example.recruit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.recruit.jdbc.company.CompanyDto;
import com.example.recruit.jdbc.member.MemberDto;
import com.example.recruit.service.CompanyService;
import com.example.recruit.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

// 공용 컨트롤러입니다. 
@Controller
public class HomeController {
	@Autowired
	MemberService memberService;
	@Autowired
	CompanyService companyService;
	
	@GetMapping("/")
	public String home() {
		System.out.println("Index Page 접속 테스트입니다~");
		return "index";
	}
	
	// 개인회원 로그인
	@PostMapping("/login/member")
	public String login(MemberDto dto, HttpSession session, Model model) {
		MemberDto result = memberService.login(dto);
		if (result != null) {
			session.setAttribute("loginMember", result);
			session.setAttribute("userType", "member");
			return "redirect:/job/main";
		} else {
			model.addAttribute("error", "아이디 또는 비밀번호가 틀렸습니다.");
			return "login";
		}
	}

	// 개인회원 가입
	@PostMapping("/register/member")
	public String regist(MemberDto dto, Model model) {
		boolean result = memberService.regist(dto);
		if (result) {
			return "redirect:/loginForm";
		} else {
			model.addAttribute("error", "이미 사용중인 아이디입니다.");
			return "regist";
		}
	}

    // 기업회원 로그인
	@GetMapping("/company/login")
	public String login(String id, String pw, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		CompanyDto result = companyService.login(id, pw);
		if (result != null) {

			session.setAttribute("cid", id);

			return "redirect:/job/main";
		} else {
			model.addAttribute("error", "아이디 또는 비밀번호를 틀리셨습니다.");
			return "/";
		}
	}
	

    // 기업회원 가입
    @PostMapping("/register/company")
    public String regist(CompanyDto dto, Model model) {
        boolean result = companyService.regist(dto);
        if (result) {
            return "redirect:/loginForm";
        } else {
            model.addAttribute("error", "이미 사용중인 아이디입니다.");
            return "regist";
        }
    }

}
