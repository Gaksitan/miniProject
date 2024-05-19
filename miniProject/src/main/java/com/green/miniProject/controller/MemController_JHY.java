package com.green.miniProject.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.miniProject.dao.IMemberDao_JHY;
import com.green.miniProject.domain.Member;
import com.green.miniProject.domain.Resume;

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
	
	@RequestMapping("/regist")
	public String regist(HttpServletRequest request) {
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String memail = request.getParameter("memail");
		String mtel = request.getParameter("mtel1") + request.getParameter("mtel2");
		String mbirthDate = request.getParameter("mbirthDate");
		String mname = request.getParameter("mname");
		String maddr1 = request.getParameter("maddr1");
		String maddr2 = request.getParameter("maddr2");
		//Date mregDate = (LocalDate)request.getParameter("mregDate");
		int mstate = Integer.parseInt(request.getParameter("mstate"));
		String mgender = request.getParameter("mgender");
		//Member member = new Member(mid, mpw, memail, mtel, mbirthDate, mname, maddr1, maddr2, mregDate, mstate, mgender);
		
		
		return "indexMem_JHY";
	}
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		
		return "loginForm_JHY";
	}
	
	
	@RequestMapping("/login")
	public String login(@RequestParam("mid") String mid, @RequestParam("mpw") String mpw, Model model, HttpServletRequest request) {
		
		Member mem = dao.loginCheck(mid, mpw);
		if(mem.getMid().equals(mid) && mem.getMid().equals(mpw)) {
			boolean tf = true;
			model.addAttribute("tf", tf);
			HttpSession session = request.getSession();
			session.setAttribute("mem", mem);
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
	
	@RequestMapping("/myResumeList")
	public String myResumeList(Model model) {
		List<Resume> myResumeList = dao.getResumeList();
		model.addAttribute("myResumeList", myResumeList);
		return "myResumeList_JHY";
	}
	
	
	
	@RequestMapping("/myResumeDetail")
	public String myResumeDetail(@RequestParam("rno") Long rno) {
		
		
		
		return "myResumeDetail_JHY";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
