package com.green.miniProject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.miniProject.dao.ICompanyDAO_JYC;
import com.green.miniProject.dao.ICompanySectorDAO_JYC;
import com.green.miniProject.dao.IEmployNoticeDAO_JYC;
import com.green.miniProject.dao.IResumeDAO_JYC;
import com.green.miniProject.dao.IScoreMemComDAO_JYC;
import com.green.miniProject.dao.ISubscribeCompanyDAO_JYC;
import com.green.miniProject.domain.Company;
import com.green.miniProject.domain.CompanySector;
import com.green.miniProject.domain.CompanySectorAndCompany;
import com.green.miniProject.domain.EmployNotice;
import com.green.miniProject.domain.Resume;
import com.green.miniProject.domain.ScoreMemCom;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/company")
public class CompanyController_JYC {

	@Autowired
	private ICompanyDAO_JYC comdao;

	@Autowired
	private IEmployNoticeDAO_JYC endao;

	@Autowired
	private IScoreMemComDAO_JYC smcdao;

	@Autowired
	private ISubscribeCompanyDAO_JYC subsdao;

	@Autowired
	private ICompanySectorDAO_JYC companySectorDao;
	
	@Autowired
	private IResumeDAO_JYC resumedao;

	@RequestMapping("/detailNoneMem")
	public String companyDetailNoneMem(@RequestParam("cno") String cno, Model model) {
		Company company = comdao.getCompany(cno);
		List<EmployNotice> enlist = endao.getEmployNoticeList(cno);
		List<ScoreMemCom> smclist = smcdao.getScoreMemComList(cno);

		model.addAttribute("company", company);
		model.addAttribute("enlist", enlist);
		model.addAttribute("smclist", smclist);

		int comCount = comdao.count();

		List<Company> comList = new ArrayList<>();
		try {
			List<CompanySectorAndCompany> companySectorAndCompanyList = companySectorDao
					.getCompanySectorAndCompanyList(cno);
			model.addAttribute("recommendList", companySectorAndCompanyList);
		} catch (Exception e) {

		}
		return "companyDetail_JYC";
	}

	@RequestMapping("/detailMem")
	public String companyDetailMem(@RequestParam("cno") String cno, Model model, HttpSession session) {
		Company company = comdao.getCompany(cno);
		List<EmployNotice> enlist = endao.getEmployNoticeList(cno);
		List<ScoreMemCom> smclist = smcdao.getScoreMemComList(cno);

		model.addAttribute("company", company);
		if (!enlist.isEmpty()) {
			model.addAttribute("enlist", enlist);
		}
		if (!smclist.isEmpty()) {
			model.addAttribute("smclist", smclist);
		}
		
		String mid = (String) session.getAttribute("mid");

		List<Resume> resumeList = resumedao.getResumeList(mid);
		
		if(!resumeList.isEmpty()) {
			model.addAttribute("resumeList", resumeList);
		}
		
		int comCount = comdao.count();

		List<Company> comList = new ArrayList<>();
		try {
			List<CompanySectorAndCompany> companySectorAndCompanyList = companySectorDao
					.getCompanySectorAndCompanyList(cno);
			model.addAttribute("recommendList", companySectorAndCompanyList);
		} catch (Exception e) {
		}

		int count = subsdao.count(mid, cno);
		if(count >= 1) {
			model.addAttribute("subscribetf", true);
		}else {
			model.addAttribute("subscribetf", false);
		}

		return "companyDetail_JYC";
	}

	@RequestMapping("/detailCom")
	public String companyDetailCom(@RequestParam("cno") String cno, Model model) {
		Company company = comdao.getCompany(cno);
		List<EmployNotice> enlist = endao.getEmployNoticeList(cno);
		List<ScoreMemCom> smclist = smcdao.getScoreMemComList(cno);

		model.addAttribute("company", company);
		model.addAttribute("enlist", enlist);
		model.addAttribute("smclist", smclist);

		int comCount = comdao.count();

		List<Company> comList = new ArrayList<>();
		try {
			List<CompanySectorAndCompany> companySectorAndCompanyList = companySectorDao
				.getCompanySectorAndCompanyList(cno);
			model.addAttribute("recommendList", companySectorAndCompanyList);
		} catch (Exception e) {
			
		}

		return "companyDetail_JYC";
	}

	@PostMapping("/subscribe")
	public void subscribe(@RequestBody Company company, HttpSession session, Model model, HttpServletResponse response) throws IOException {
		String mid = (String)session.getAttribute("mid");
		
		String cno = company.getCno();
		
		subsdao.subscribeCompany(mid, cno);
		
	}

	@PostMapping("/unsubscribe")
	public void unsubscribe(@RequestBody Company company, HttpSession session, Model model, HttpServletResponse response) throws IOException {

		String cno = company.getCno();
		
		
		String mid = (String) session.getAttribute("mid");

		subsdao.unsubscribeCompany(mid, cno);
		
	}
}
