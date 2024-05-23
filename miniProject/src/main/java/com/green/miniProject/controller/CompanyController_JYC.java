package com.green.miniProject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
import com.green.miniProject.domain.SubscribeCompany;
import com.green.miniProject.domain.SubscribeCompanyDetail;
import com.green.miniProject.service.EmployNoticeService_jyc;
import com.green.miniProject.service.SubscribeCompanyService_JYC;

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

	@Autowired
	private EmployNoticeService_jyc employNoticeService;

	@Autowired
	private ICompanySectorDAO_JYC comSecDao;

	@Autowired
	private SubscribeCompanyService_JYC subscribeService;

	// @RequestMapping("/detailNoneMem")
	public String companyDetailNoneMem(@RequestParam("cno") String cno, Model model) {
		
		
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

		int comCount = comdao.count();
		List<Company> comList = new ArrayList<>();

		String scname = companySectorDao.getScname(cno);
		List<CompanySectorAndCompany> companySectorAndCompanyList = companySectorDao
				.getCompanySectorAndCompanyList(scname, cno);
		if (companySectorAndCompanyList.size() > 0) {
			model.addAttribute("recommendList", companySectorAndCompanyList);
		}

		return "companyDetail_JYC";
	}

	@RequestMapping("/detailMem")
	public String companyDetailMem(Model model, @RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam("cno") String cno, HttpSession session) {

		Page<com.green.miniProject.entity.EmployNotice> paging = employNoticeService.getList(page);
		String str;

		for (int i = 0; i < paging.getContent().size(); i++) {
			if (paging.getContent().get(i).getEntitle().length() > 30) {
				str = paging.getContent().get(i).getEntitle().substring(0, 30);
				paging.getContent().get(i).setEntitle(str + "...");
			}
		}

		model.addAttribute("enlist", paging.getContent());
		model.addAttribute("totalPages", paging.getTotalPages());
		model.addAttribute("hasNext", paging.hasNext());
		model.addAttribute("hasPrevious", paging.hasPrevious());

		Company company = comdao.getCompany(cno);
		List<ScoreMemCom> smclist = smcdao.getScoreMemComList(cno);

		model.addAttribute("company", company);
		if (!smclist.isEmpty()) {
			model.addAttribute("smclist", smclist);
		}

		int comCount = comdao.count();
		List<Company> comList = new ArrayList<>();

		String scname = companySectorDao.getScname(cno);
		List<CompanySectorAndCompany> companySectorAndCompanyList = companySectorDao
				.getCompanySectorAndCompanyList(scname, cno);
		if (companySectorAndCompanyList.size() > 0) {
			model.addAttribute("recommendList", companySectorAndCompanyList);
		}

		String mid = (String) session.getAttribute("mid");
		List<Resume> resumeList = resumedao.getResumeList(mid);

		if (!resumeList.isEmpty()) {
			model.addAttribute("resumeList", resumeList);
		}

		int count = subsdao.count(mid, cno);
		if (count >= 1) {
			model.addAttribute("subscribetf", true);
		} else {
			model.addAttribute("subscribetf", false);
		}

		return "companyDetail_JYC";
	}

	@RequestMapping("/detailNoneMem")
	public String list(Model model, @RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam("cno") String cno) {

		Page<com.green.miniProject.entity.EmployNotice> paging = employNoticeService.getList(page);
		String str;

		for (int i = 0; i < paging.getContent().size(); i++) {
			if (paging.getContent().get(i).getEntitle().length() > 30) {
				str = paging.getContent().get(i).getEntitle().substring(0, 30);
				paging.getContent().get(i).setEntitle(str + "...");
				System.out.println(paging.getContent().get(i).getEntitle());
			}
		}

		model.addAttribute("enlist", paging.getContent());
		model.addAttribute("totalPages", paging.getTotalPages());
		model.addAttribute("hasNext", paging.hasNext());
		model.addAttribute("hasPrevious", paging.hasPrevious());

		Company company = comdao.getCompany(cno);
		List<ScoreMemCom> smclist = smcdao.getScoreMemComList(cno);

		model.addAttribute("company", company);
		if (!smclist.isEmpty()) {
			model.addAttribute("smclist", smclist);
		}

		int comCount = comdao.count();
		List<Company> comList = new ArrayList<>();

		String scname = companySectorDao.getScname(cno);
		List<CompanySectorAndCompany> companySectorAndCompanyList = companySectorDao
				.getCompanySectorAndCompanyList(scname, cno);
		if (companySectorAndCompanyList.size() > 0) {
			model.addAttribute("recommendList", companySectorAndCompanyList);
		}

		return "companyDetail_JYC";
	}

	@RequestMapping("/detailCom")
	public String companyDetailCom(Model model, @RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam("cno") String cno) {
		Page<com.green.miniProject.entity.EmployNotice> paging = employNoticeService.getList(page);
		model.addAttribute("enlist", paging.getContent());
		model.addAttribute("totalPages", paging.getTotalPages());
		model.addAttribute("hasNext", paging.hasNext());
		model.addAttribute("hasPrevious", paging.hasPrevious());

		Company company = comdao.getCompany(cno);
		List<ScoreMemCom> smclist = smcdao.getScoreMemComList(cno);

		model.addAttribute("company", company);
		if (!smclist.isEmpty()) {
			model.addAttribute("smclist", smclist);
		}

		int comCount = comdao.count();
		List<Company> comList = new ArrayList<>();

		String scname = companySectorDao.getScname(cno);
		List<CompanySectorAndCompany> companySectorAndCompanyList = companySectorDao
				.getCompanySectorAndCompanyList(scname, cno);
		if (companySectorAndCompanyList.size() > 0) {
			model.addAttribute("recommendList", companySectorAndCompanyList);
		}

		return "companyDetail_JYC";
	}

	@PostMapping("/subscribe")
	public void subscribe(@RequestBody Company company, HttpSession session, Model model, HttpServletResponse response)
			throws IOException {
		String mid = (String) session.getAttribute("mid");

		String cno = company.getCno();

		subsdao.subscribeCompany(mid, cno);
	}

	@PostMapping("/unsubscribe")
	public void unsubscribe(@RequestBody Company company, HttpSession session, Model model,
			HttpServletResponse response) throws IOException {
		String cno = company.getCno();

		String mid = (String) session.getAttribute("mid");

		subsdao.unsubscribeCompany(mid, cno);
	}

	@PostMapping("/unsubscribe2")
	public @ResponseBody String unsubscribe2(@RequestBody SubscribeCompany sc, HttpSession session,
			HttpServletResponse response) {

		String mid = (String) session.getAttribute("mid");

		int count = subsdao.count(mid, sc.getCno());

		if (count > 0) {
			subsdao.unsubscribeCompany(mid, sc.getCno());
		} else {
			subsdao.subscribeCompany(mid, sc.getCno());
		}

		return "";
	}

	// @GetMapping("/subscribeAndScrap")
	public String subscribeAndScrap(@RequestParam(value = "page", defaultValue = "1") int page) {

		Page<com.green.miniProject.entity.SubscribeCompany> paging = subscribeService.getList(page);

		System.out.println(paging.getContent());
		System.out.println(paging.getContent().get(0));

		return "";
	}
}
