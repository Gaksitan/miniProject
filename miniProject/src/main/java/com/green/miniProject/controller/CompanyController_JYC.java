package com.green.miniProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.miniProject.dao.ICompanyDAO_JYC;
import com.green.miniProject.dao.IEmployNoticeDAO_JYC;
import com.green.miniProject.dao.IScoreMemComDAO_JYC;
import com.green.miniProject.domain.Company;
import com.green.miniProject.domain.EmployNotice;
import com.green.miniProject.domain.ScoreMemCom;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/com")
public class CompanyController_JYC {

	@Autowired
	private ICompanyDAO_JYC comdao;

	@Autowired
	private IEmployNoticeDAO_JYC endao;
	
	@Autowired
	private IScoreMemComDAO_JYC smcdao;
	
	@RequestMapping("/companyDetail")
	public String companyDetail(@RequestParam("cno") String cno, Model model) {
		Company company  = comdao.getCompany(cno);
		List<EmployNotice> enlist = endao.getEmployNoticeList(cno);
		List<ScoreMemCom> smclist = smcdao.getScoreMemComList(cno);
		
		model.addAttribute("company", company);
		model.addAttribute("enlist", enlist);
		model.addAttribute("smclist", smclist);
		
		return "companyDetail_JYC";
	}
	
}
