package com.green.miniProject.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.miniProject.dao.IMemberDao_JHY;
import com.green.miniProject.domain.JoinApplyResumeList;
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
		String mtel = request.getParameter("mtel2");
		String mbirthDate_ = request.getParameter("mbirthDate");
		LocalDate mbirthDate = LocalDate.parse(mbirthDate_, DateTimeFormatter.ISO_LOCAL_DATE);
		String mname = request.getParameter("mname");
		String maddr1 = request.getParameter("maddr1");
		String maddr2 = request.getParameter("maddr2");
		LocalDate mregDate = LocalDate.now();
		int mstate = Integer.parseInt(request.getParameter("mstate"));
		char mgender = (request.getParameter("mgender")).charAt(0);
		Member member = new Member(mid, mpw, memail, mtel, mbirthDate, mname, maddr1, maddr2, mregDate, mstate, mgender);
		dao.regist(member);
		
		return "indexMem_JHY";
	}
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		
		return "loginForm_JHY";
	}
	
	
	@RequestMapping("/login")
	public String login(@RequestParam("mid") String mid, @RequestParam("mpw") String mpw, Model model, HttpServletRequest request) {
		
		Member mem = dao.loginCheck(mid, mpw);
		boolean tf = false;
		if(mem != null) {
			if(mem.getMid().equals(mid) && mem.getMpw().equals(mpw)) {
				tf = true;
				model.addAttribute("tf", tf);
				HttpSession session = request.getSession();
				session.setAttribute("mem", mem);
				session.setAttribute("mid", mid);
				session.setAttribute("mpw", mpw);
				return "indexMem_JHY";
			}else {
				
			}
		}
		
		model.addAttribute("tf", tf);
		return "loginForm_JHY";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "indexMem_JHY";
	}
	
	// 내 이력서 목록 페이지
	@RequestMapping("/myResumeList")
	public String myResumeList(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("mid");
		List<Resume> myResumeList = dao.getResumeList(mid);
		model.addAttribute("myResumeList", myResumeList);
		return "myResumeList_JHY";
	}
	
	// 내 이력서 상세보기 페이지
	@RequestMapping("/myResumeDetail")
	public String myResumeDetail(@RequestParam("rno") Long rno, Model model) {
		if(rno != null) {
			Resume resume = dao.getResume(rno);
			String mid = resume.getMid();
			Member mem = dao.getMember(mid);
			model.addAttribute("resume", resume);
			model.addAttribute("member", mem);
		}else {
			
		}
		return "myResumeDetail_JHY";
	}
	
	// 이력서 작성(rno == null)
	@RequestMapping("/writeResume")
	public String writeResume(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String mid = (String) session.getAttribute("mid");
		String rintro = request.getParameter("rintro");
		String rimgPath = request.getParameter("rimgPath");
		String rpublic_ = request.getParameter("rimgPath");
		boolean rpublic;
		if(rpublic_ == "true") {
			rpublic = true;
		}else {
			rpublic = false;
		}
		String rtitle = request.getParameter("rimgPath");
		String rmain_ = request.getParameter("rimgPath");
		boolean rmain;
		if(rmain_ == "true") {
			rmain = true;
		}else {
			rmain = false;
		}
		LocalDate rregdate = LocalDate.now();
		Resume resume = new Resume(null, mid, rintro, rimgPath, rpublic, rtitle, rmain, rregdate);
		dao.writeResume(resume);
		
		return "myResumeList_JHY";
	}
	
	// 이력서 수정(rno != null)
	@RequestMapping("/updateResume")
	public String updateResume(HttpServletRequest request) {
		String rno_ = request.getParameter("rno");
		Long rno = Long.parseLong(rno_);
		Resume resume = dao.getResume(rno);
		String mid = resume.getMid();
		String rintro = request.getParameter("rintro");
		String rimgPath = request.getParameter("rimgPath");
		String rpublic_ = request.getParameter("rpublic");
		Boolean rpublic;
		if(rpublic_ == "true") {
			rpublic = true;
		}else {
			rpublic = false;
		}
		String rtitle = request.getParameter("rtitle");
		String rmain_ = request.getParameter("rmain");
		Boolean rmain;
		if(rmain_ == "true") {
			rmain = true;
		}else {
			rmain = false;
		}
		LocalDate rregdate = LocalDate.now();
		Resume updateResume = new Resume(rno, mid, rintro, rimgPath, rpublic, rtitle, rmain, rregdate);
		dao.updateResume(updateResume);
		return "myResumeList_JHY";
	}
	
	
	@RequestMapping("/myApplyList")
	public String myApplyList(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String mid = (String) session.getAttribute("mid");
		List<JoinApplyResumeList> list = dao.applyResumeList(mid);
		model.addAttribute("myApplyList", list);
		
		return "myApplyList_JHY";
	}
	
	
	
	
	
}
