package com.example.recruit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.recruit.jdbc.company.CompanyDto;
import com.example.recruit.jdbc.member.MemberDto;
import com.example.recruit.service.CompanyService;
import com.example.recruit.service.JobService;
import com.example.recruit.service.MemberService;
import com.example.recruit.util.PageHandler;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    MemberService memberService;

    @Autowired
    CompanyService companyService;

    @Autowired
    JobService jobService;

    @GetMapping("/")
    public String home(@RequestParam(name = "page", defaultValue = "1") int page,
                       @RequestParam(name = "cat", required = false) String cat,
                       @RequestParam(name = "searchText", required = false) String searchText,
                       @RequestParam(name = "startDate", required = false) String startDate,
                       @RequestParam(name = "endDate", required = false) String endDate,
                       // ▼ 여기가 지워져 있었습니다! 다시 추가해 주세요 ▼
                       @RequestParam(name = "sort", defaultValue = "jno") String sort,   
                       @RequestParam(name = "order", defaultValue = "desc") String order,
                       Model model) {

        // 빈 문자열은 null로 처리
        if (searchText != null && searchText.trim().isEmpty()) searchText = null;
        if (cat != null && cat.trim().isEmpty()) cat = null;
        if (startDate != null && startDate.trim().isEmpty()) startDate = null;
        if (endDate != null && endDate.trim().isEmpty()) endDate = null;

        int pageSize = 10;
        int totalCount = jobService.totalCount(cat, searchText, startDate, endDate);
        PageHandler ph = new PageHandler(totalCount, page, pageSize);

        // 페이지네이션에 검색 파라미터 유지
        String searchParam = "";
        if (cat != null) searchParam += "&cat=" + cat;
        if (searchText != null) searchParam += "&searchText=" + searchText;
        if (startDate != null) searchParam += "&startDate=" + startDate;
        if (endDate != null) searchParam += "&endDate=" + endDate;
        
        // ▼ 페이지를 넘겨도 정렬 상태가 안 풀리도록 꼬리표에 붙여줍니다 ▼
        searchParam += "&sort=" + sort + "&order=" + order;

        model.addAttribute("jobList", jobService.list(page, pageSize, cat, searchText, startDate, endDate, sort, order));
        model.addAttribute("ph", ph);
        model.addAttribute("cat", cat);
        model.addAttribute("searchText", searchText);
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        model.addAttribute("searchParam", searchParam);
        
        // ▼ index.jsp에서 제목, 마감일 옆에 화살표(▲/▼)를 띄우기 위해 꼭 필요합니다 ▼
        model.addAttribute("currentSort", sort);
        model.addAttribute("currentOrder", order);

        return "index";
    }

    // 로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    // 로그인 페이지
    @GetMapping("/loginForm")
    public String loginPage() {
        return "login";
    }

    // 개인회원 로그인
    @PostMapping("/login/member")
    public String loginM(MemberDto dto, Model model, HttpSession session) {
        MemberDto result = memberService.login(dto);
        if (result != null) {
            session.setAttribute("loginMember", result);
            session.setAttribute("loginName", result.getMname());
            session.setAttribute("userType", "member");
            session.setAttribute("alertMsg", result.getMname() + "님 로그인 되었습니다.");
            return "redirect:/";
        } else {
            model.addAttribute("error", "아이디 또는 비밀번호가 틀렸습니다.");
            return "login";
        }
    }

    // 회원가입 페이지
    @GetMapping("/registForm")
    public String registPage() {
        return "regist";
    }

    // 개인회원 가입
    @PostMapping("/register/member")
    public String registM(MemberDto dto, Model model, HttpSession session) {
        boolean result = memberService.regist(dto);
        if (result) {
            session.setAttribute("alertMsg", "회원가입 되었습니다. 로그인 페이지로 이동합니다.");
            return "redirect:/loginForm";
        } else {
            model.addAttribute("error", "이미 사용중인 아이디입니다.");
            return "regist";
        }
    }

    // 기업회원 로그인
    @PostMapping("/login/company")
    public String loginC(CompanyDto dto, Model model, HttpSession session) {
        CompanyDto result = companyService.login(dto);
        if (result != null) {
            session.setAttribute("loginCompany", result);
            session.setAttribute("loginName", result.getCname());
            session.setAttribute("userType", "company");
            session.setAttribute("alertMsg", result.getCname() + "님 로그인 되었습니다.");
            return "redirect:/";
        } else {
            model.addAttribute("error", "아이디 또는 비밀번호가 틀렸습니다.");
            return "login";
        }
    }

    // 기업회원 가입
    @PostMapping("/register/company")
    public String registC(CompanyDto dto, Model model, HttpSession session) {
        boolean result = companyService.regist(dto);
        if (result) {
            session.setAttribute("alertMsg", "회원가입 되었습니다. 로그인 페이지로 이동합니다.");
            return "redirect:/loginForm";
        } else {
            model.addAttribute("error", "이미 사용중인 아이디입니다.");
            return "regist";
        }
    }
}
