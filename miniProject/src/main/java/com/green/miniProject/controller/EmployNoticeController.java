package com.green.miniProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.miniProject.dao.ICertificateEmployNoticeDAO_JYC;
import com.green.miniProject.dao.ICompanyDAO_JYC;
import com.green.miniProject.dao.IDegreeEmployNoticeDAO_JYC;
import com.green.miniProject.dao.IEmployNoticeDAO_JYC;
import com.green.miniProject.dao.IExperienceEmployNoticeDAO_JYC;
import com.green.miniProject.dao.IPreferenceEmployNoticeDAO_JYC;
import com.green.miniProject.dao.ISkillEmployNoticeDAO_JYC;
import com.green.miniProject.dao.IWelfareEmployNoticeDAO_JYC;
import com.green.miniProject.domain.EmployNotice;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/employnotice")
public class EmployNoticeController {

	@Autowired
	private IEmployNoticeDAO_JYC employNoticeDao;
	
	@Autowired
	private IDegreeEmployNoticeDAO_JYC degreeEmployNoticeDao; 
	
	@Autowired
	private IExperienceEmployNoticeDAO_JYC experienceEmployNoticeDao;

	@Autowired
	private ISkillEmployNoticeDAO_JYC skillEmployNoticeDao;
	
	@Autowired
	private IWelfareEmployNoticeDAO_JYC welfareEmployNoticeDao;
	
	@Autowired
	private IPreferenceEmployNoticeDAO_JYC preferenceEmployNoticeDao;

	@Autowired
	private ICertificateEmployNoticeDAO_JYC certificateEmployNoticeDao;
	
	@Autowired
	private ICompanyDAO_JYC companyDao;
	
	@GetMapping("/detail")
	public String detail(@RequestParam("cno") String cno, @RequestParam("enno") Long enno, Model model) {
		
		model.addAttribute("employNoticeDto", employNoticeDao.getEmployNotice(cno, enno));
		model.addAttribute("adddegreeEmployNoticeList", degreeEmployNoticeDao.getDegreeEmployNoticeList(enno));
		model.addAttribute("experienceEmployNoticeList", experienceEmployNoticeDao.getExperienceEmployNoticeList(enno));
		model.addAttribute("skillEmployNoticeList", skillEmployNoticeDao.getSkillEmployNoticeList(enno));
		model.addAttribute("welfareEmployNoticeList", welfareEmployNoticeDao.getWelfareEmployNoticeList(enno));
		model.addAttribute("preferenceEmployNoticeList", preferenceEmployNoticeDao.getPreferenceEmployNoticeList(enno));
		model.addAttribute("certificateEmployNoticeList", certificateEmployNoticeDao.getCertificateEmployNoticeList(enno));
		model.addAttribute("company", companyDao.getCompany(cno));
		return "employNoticeDetail_JYC.jsp";
	}
	
}
