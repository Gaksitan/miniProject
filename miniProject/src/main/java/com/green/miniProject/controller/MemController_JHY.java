package com.green.miniProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.miniProject.dao.IMemberDao_JHY;
import com.green.miniProject.domain.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/mem")
public class MemController_JHY {
	
	@Autowired
	IMemberDao_JHY dao;
	
	@RequestMapping("/indexMem")
	public String indexMem() {
		
		return "indexMem_JHY";
	}
	
	@RequestMapping("/regFormMem")
	public String regFormMem() {
		
		return "regFormMem_JHY";
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam("mid") String mid, @RequestParam("mpw") String mpw, Model model, HttpServletRequest request) {
		
		Member mem = dao.loginCheck(mid, mpw);
		if(mem.getMid().equals(mid) && mem.getMid().equals(mpw)) {
			boolean tf = true;
			model.addAttribute("tf", tf);
			HttpSession session = request.getSession();
			session.setAttribute("mid", mid);
			session.setAttribute("mpw", mpw);
			return "indexMem_JHY";
		}else {
			boolean tf = false;	
			model.addAttribute("tf", tf);
		}
		return "loginForm_JHY";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "indexMem_JHY";
	}
	
	@RequestMapping("/myResumeDetail")
	public String myResumeDetail(@RequestParam("rno") Long rno) {
		
		
		
		return "myResumeDetail_JHY";
	}
	
	
}
