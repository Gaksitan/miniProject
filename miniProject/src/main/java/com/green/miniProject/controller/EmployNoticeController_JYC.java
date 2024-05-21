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
import com.green.miniProject.dao.IScrapEmployNoticeDAO_JYC;
import com.green.miniProject.dao.ISkillEmployNoticeDAO_JYC;
import com.green.miniProject.dao.IWelfareEmployNoticeDAO_JYC;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/employnotice")
public class EmployNoticeController_JYC {

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
	
	@Autowired
	private IScrapEmployNoticeDAO_JYC scrapdao;
	
	@GetMapping("/list")
	public String employNoticeList(Model model) {
		
		model.addAttribute("employNoticeList", employNoticeDao.getAllEmployNoticeList());
		return "employNoticeList_JYC";
	}
	
	@GetMapping("/detailNoneMem")
	public String detailNoneMem(@RequestParam("enno") Long enno, Model model) {
		
		model.addAttribute("employNoticeDto", employNoticeDao.getEmployNotice(enno));
		if(!degreeEmployNoticeDao.getDegreeEmployNoticeList(enno).isEmpty()) {
			model.addAttribute("degreeEmployNoticeList", degreeEmployNoticeDao.getDegreeEmployNoticeList(enno));
		}
		if(!experienceEmployNoticeDao.getExperienceEmployNoticeList(enno).isEmpty()) {
			model.addAttribute("experienceEmployNoticeList", experienceEmployNoticeDao.getExperienceEmployNoticeList(enno));
		}
		if (!skillEmployNoticeDao.getSkillEmployNoticeList(enno).isEmpty()) {
			model.addAttribute("skillEmployNoticeList", skillEmployNoticeDao.getSkillEmployNoticeList(enno));
		}
		if (!welfareEmployNoticeDao.getWelfareEmployNoticeList(enno).isEmpty()) {
			model.addAttribute("welfareEmployNoticeList", welfareEmployNoticeDao.getWelfareEmployNoticeList(enno));
		}
		if (!preferenceEmployNoticeDao.getPreferenceEmployNoticeList(enno).isEmpty()) {
			model.addAttribute("preferenceEmployNoticeList", preferenceEmployNoticeDao.getPreferenceEmployNoticeList(enno));
		}
		if (!certificateEmployNoticeDao.getCertificateEmployNoticeList(enno).isEmpty()) {
			model.addAttribute("certificateEmployNoticeList", certificateEmployNoticeDao.getCertificateEmployNoticeList(enno));
		}
		
		return "employNoticeDetail_JYC";
	}
	
	@GetMapping("/detailMem")
	public String detailMem(@RequestParam("enno") Long enno, Model model, HttpServletRequest request) {
		
		model.addAttribute("employNoticeDto", employNoticeDao.getEmployNotice(enno));
		if(!degreeEmployNoticeDao.getDegreeEmployNoticeList(enno).isEmpty()) {
			model.addAttribute("degreeEmployNoticeList", degreeEmployNoticeDao.getDegreeEmployNoticeList(enno));
		}
		if(!experienceEmployNoticeDao.getExperienceEmployNoticeList(enno).isEmpty()) {
			model.addAttribute("experienceEmployNoticeList", experienceEmployNoticeDao.getExperienceEmployNoticeList(enno));
		}
		if (!skillEmployNoticeDao.getSkillEmployNoticeList(enno).isEmpty()) {
			model.addAttribute("skillEmployNoticeList", skillEmployNoticeDao.getSkillEmployNoticeList(enno));
		}
		if (!welfareEmployNoticeDao.getWelfareEmployNoticeList(enno).isEmpty()) {
			model.addAttribute("welfareEmployNoticeList", welfareEmployNoticeDao.getWelfareEmployNoticeList(enno));
		}
		if (!preferenceEmployNoticeDao.getPreferenceEmployNoticeList(enno).isEmpty()) {
			model.addAttribute("preferenceEmployNoticeList", preferenceEmployNoticeDao.getPreferenceEmployNoticeList(enno));
		}
		if (!certificateEmployNoticeDao.getCertificateEmployNoticeList(enno).isEmpty()) {
			model.addAttribute("certificateEmployNoticeList", certificateEmployNoticeDao.getCertificateEmployNoticeList(enno));
		}
		
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("mid");
		
		try {
			int count = scrapdao.count(enno, mid);
			model.addAttribute("scraptf", true);
			
		}catch (Exception e) {
			model.addAttribute("scraptf", false);
		}
		return "employNoticeDetail_JYC";
	}
	
	@GetMapping("/detailCom")
	public String detailCom(@RequestParam("enno") Long enno, Model model) {
		
		model.addAttribute("employNoticeDto", employNoticeDao.getEmployNotice(enno));
		if(!degreeEmployNoticeDao.getDegreeEmployNoticeList(enno).isEmpty()) {
			model.addAttribute("degreeEmployNoticeList", degreeEmployNoticeDao.getDegreeEmployNoticeList(enno));
		}
		if(!experienceEmployNoticeDao.getExperienceEmployNoticeList(enno).isEmpty()) {
			model.addAttribute("experienceEmployNoticeList", experienceEmployNoticeDao.getExperienceEmployNoticeList(enno));
		}
		if (!skillEmployNoticeDao.getSkillEmployNoticeList(enno).isEmpty()) {
			model.addAttribute("skillEmployNoticeList", skillEmployNoticeDao.getSkillEmployNoticeList(enno));
		}
		if (!welfareEmployNoticeDao.getWelfareEmployNoticeList(enno).isEmpty()) {
			model.addAttribute("welfareEmployNoticeList", welfareEmployNoticeDao.getWelfareEmployNoticeList(enno));
		}
		if (!preferenceEmployNoticeDao.getPreferenceEmployNoticeList(enno).isEmpty()) {
			model.addAttribute("preferenceEmployNoticeList", preferenceEmployNoticeDao.getPreferenceEmployNoticeList(enno));
		}
		if (!certificateEmployNoticeDao.getCertificateEmployNoticeList(enno).isEmpty()) {
			model.addAttribute("certificateEmployNoticeList", certificateEmployNoticeDao.getCertificateEmployNoticeList(enno));
		}
		
		return "employNoticeDetail_JYC";
	}
	
	@GetMapping("/scrap")
	public String scrap(@RequestParam("enno") Long enno, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("mid");
		
		scrapdao.scrapEmployNotice(enno, mid);
		
		return "redirect:/employnotice/detailMem?enno=" + enno;
	}
	
	@GetMapping("/deleteScrap")
	public String deleteScrap(@RequestParam("enno") Long enno, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("mid");
		
		scrapdao.unscrapEmployNotice(enno, mid);
		
		return "redirect:/employnotice/detailMem?enno=" + enno;
	}
	
}
