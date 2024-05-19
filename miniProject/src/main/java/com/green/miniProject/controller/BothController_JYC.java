package com.green.miniProject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.miniProject.dao.ICompanyDAO_JYC;
import com.green.miniProject.dao.IEmployNoticeDAO_JYC;
import com.green.miniProject.dao.IMemberDAO_JYC;
import com.green.miniProject.domain.Company;
import com.green.miniProject.domain.EmployNotice;
import com.green.miniProject.domain.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/both")
@Log4j2
public class BothController_JYC {

	@Autowired
	private IEmployNoticeDAO_JYC endao;

	@Autowired
	private ICompanyDAO_JYC comdao;
	
	@Autowired
	private IMemberDAO_JYC memdao;
	
	@RequestMapping("/a")
	public String header() {
		return "header_JYC";
	}
	
	@RequestMapping("/serviceMainBoth")
	public String serviceMain(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("mid", "aaa");
		return "serviceMainBoth_JYC";
	}
	
	@GetMapping("/searchResultNoMem")
	public String searchResultMem(@RequestParam("search") String search, Model model) {
		
		List<Company> comlist = comdao.getCompanyList(search);
		model.addAttribute("comlist", comlist);
		model.addAttribute("comcount", comlist.size());
		
		List<EmployNotice> enlist = endao.searchEmployNoticeList(search);
		model.addAttribute("enlist", enlist);
		model.addAttribute("encount", enlist.size());
		
		List<Member> memlist = memdao.getMemberList(search);
		model.addAttribute("memlist", memlist);
		model.addAttribute("memcount", memlist.size());
		
		return "searchResult_JYC";
	}
	
	@GetMapping("/searchResultMem")
	public String searchResultMem(Model model, @RequestParam("search") String search) {
		
		List<Company> comlist = comdao.getCompanyList(search);
		model.addAttribute("comlist", comlist);
		model.addAttribute("comcount", comlist.size());
		
		List<EmployNotice> enlist = endao.searchEmployNoticeList(search);
		model.addAttribute("enlist", enlist);
		model.addAttribute("encount", enlist.size());
		
		List<Member> memlist = memdao.getMemberList(search);
		model.addAttribute("memlist", memlist);
		model.addAttribute("memcount", memlist.size());
		
		
		return "searchResult_JYC";
	}
	
	@GetMapping("/searchResultCom")
	public String searchResultCom(@RequestParam("search") String search, Model model) {
		
		List<Company> comlist = comdao.getCompanyList(search);
		model.addAttribute("comlist", comlist);
		model.addAttribute("comcount", comlist.size());
		
		List<EmployNotice> enlist = endao.searchEmployNoticeList(search);
		model.addAttribute("enlist", enlist);
		model.addAttribute("encount", enlist.size());
		
		List<Member> memlist = memdao.getMemberList(search);
		model.addAttribute("memlist", memlist);
		model.addAttribute("memcount", memlist.size());
		
		return "searchResult_JYC";
	}
	
	@GetMapping("/registQuestionForm")
	public String registQuestionForm() {
		return "registQuestionForm_JYC";
	}
}
