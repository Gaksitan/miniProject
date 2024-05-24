package com.green.miniProject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.green.miniProject.dao.IApplyResumeDAO_JYC;
import com.green.miniProject.dao.ICertificateEmployNoticeDAO_JYC;
import com.green.miniProject.dao.ICompanyDAO_JYC;
import com.green.miniProject.dao.IDegreeEmployNoticeDAO_JYC;
import com.green.miniProject.dao.IEmployNoticeDAO_JYC;
import com.green.miniProject.dao.IExperienceEmployNoticeDAO_JYC;
import com.green.miniProject.dao.IPreferenceEmployNoticeDAO_JYC;
import com.green.miniProject.dao.IResumeDAO_JYC;
import com.green.miniProject.dao.IScrapEmployNoticeDAO_JYC;
import com.green.miniProject.dao.ISkillEmployNoticeDAO_JYC;
import com.green.miniProject.dao.IWelfareEmployNoticeDAO_JYC;
import com.green.miniProject.domain.ApplyResume;
import com.green.miniProject.domain.CompanySectorAndCompany;
import com.green.miniProject.domain.EmployNoticeDetail;
import com.green.miniProject.domain.ScrapEmployNoticeDetail;
import com.green.miniProject.entity.EmployNotice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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

	@Autowired
	private IResumeDAO_JYC resumedao;

	@Autowired
	private IApplyResumeDAO_JYC ardao;

	@GetMapping("/list")
	public String employNoticeList(Model model) {

		List<com.green.miniProject.domain.EmployNotice> employNoticeList = employNoticeDao.getAllEmployNoticeListOrderByEnddateAsc();
		String str;
		
		for(int i = 0; i < employNoticeList.size(); i++) {
			
			if(employNoticeList.get(i).getEntitle().length() > 20) {				
			str = employNoticeList.get(i).getEntitle().substring(0, 20);
			employNoticeList.get(i).setEntitle(str);
			}
		}
		
		model.addAttribute("employNoticeList", employNoticeList);
		
		
		
		
		
		return "employNoticeList_JYC";
	}

	@GetMapping("/employNoticeList")
	public String employNoticeList(@RequestParam("cno") String cno, Model model) {


		List<com.green.miniProject.domain.EmployNotice> employNoticeList = employNoticeDao.getAllEmployNoticeListOrderByEnddateAsc();
		String str;
		
		for(int i = 0; i < employNoticeList.size(); i++) {
			
			if(employNoticeList.get(i).getEntitle().length() > 20) {				
			str = employNoticeList.get(i).getEntitle().substring(0, 20);
			employNoticeList.get(i).setEntitle(str);
			}
		}
		
		model.addAttribute("employNoticeList", employNoticeList);
		model.addAttribute("cno", cno);
		
		return "employNoticeList_JYC";
	}

	@GetMapping("/detailNoneMem")
	public String detailNoneMem(@RequestParam("enno") Long enno, Model model) {

		model.addAttribute("employNoticeDto", employNoticeDao.getEmployNotice(enno));
		
		if (!degreeEmployNoticeDao.getDegreeEmployNoticeList(enno).isEmpty()) {
			model.addAttribute("degreeEmployNoticeList", degreeEmployNoticeDao.getDegreeEmployNoticeList(enno));
		}
		if (!experienceEmployNoticeDao.getExperienceEmployNoticeList(enno).isEmpty()) {
			model.addAttribute("experienceEmployNoticeList",
					experienceEmployNoticeDao.getExperienceEmployNoticeList(enno));
		}
		if (!skillEmployNoticeDao.getSkillEmployNoticeList(enno).isEmpty()) {
			model.addAttribute("skillEmployNoticeList", skillEmployNoticeDao.getSkillEmployNoticeList(enno));
		}
		if (!welfareEmployNoticeDao.getWelfareEmployNoticeList(enno).isEmpty()) {
			model.addAttribute("welfareEmployNoticeList", welfareEmployNoticeDao.getWelfareEmployNoticeList(enno));
		}
		if (!preferenceEmployNoticeDao.getPreferenceEmployNoticeList(enno).isEmpty()) {
			model.addAttribute("preferenceEmployNoticeList",
					preferenceEmployNoticeDao.getPreferenceEmployNoticeList(enno));
		}
		if (!certificateEmployNoticeDao.getCertificateEmployNoticeList(enno).isEmpty()) {
			model.addAttribute("certificateEmployNoticeList",
					certificateEmployNoticeDao.getCertificateEmployNoticeList(enno));
		}

		String enposition = employNoticeDao.getEmployNotice(enno).getEnposition();
		List<EmployNoticeDetail> recommendList = employNoticeDao.getEmployNoticeListSamePosition(enno, enposition);
		
		if(recommendList.size() > 0) {
			
			String str;
			for(int i = 0; i < recommendList.size(); i++) {
				if(recommendList.get(i).getEntitle().length() > 20) {
					str = recommendList.get(i).getEntitle().substring(0, 20);
					recommendList.get(i).setEntitle(str + "...");
				}
			}
			
			model.addAttribute("recommendList", recommendList);
		}
		
		return "employNoticeDetail_JYC";
	}

	@GetMapping("/detailMem")
	public String detailMem(@RequestParam("enno") Long enno, Model model, HttpSession session) {

		model.addAttribute("employNoticeDto", employNoticeDao.getEmployNotice(enno));
		if (!degreeEmployNoticeDao.getDegreeEmployNoticeList(enno).isEmpty()) {
			model.addAttribute("degreeEmployNoticeList", degreeEmployNoticeDao.getDegreeEmployNoticeList(enno));
		}
		if (!experienceEmployNoticeDao.getExperienceEmployNoticeList(enno).isEmpty()) {
			model.addAttribute("experienceEmployNoticeList",
					experienceEmployNoticeDao.getExperienceEmployNoticeList(enno));
		}
		if (!skillEmployNoticeDao.getSkillEmployNoticeList(enno).isEmpty()) {
			model.addAttribute("skillEmployNoticeList", skillEmployNoticeDao.getSkillEmployNoticeList(enno));
		}
		if (!welfareEmployNoticeDao.getWelfareEmployNoticeList(enno).isEmpty()) {
			model.addAttribute("welfareEmployNoticeList", welfareEmployNoticeDao.getWelfareEmployNoticeList(enno));
		}
		if (!preferenceEmployNoticeDao.getPreferenceEmployNoticeList(enno).isEmpty()) {
			model.addAttribute("preferenceEmployNoticeList",
					preferenceEmployNoticeDao.getPreferenceEmployNoticeList(enno));
		}
		if (!certificateEmployNoticeDao.getCertificateEmployNoticeList(enno).isEmpty()) {
			model.addAttribute("certificateEmployNoticeList",
					certificateEmployNoticeDao.getCertificateEmployNoticeList(enno));
		}

		String enposition = employNoticeDao.getEmployNotice(enno).getEnposition();
		List<EmployNoticeDetail> recommendList = employNoticeDao.getEmployNoticeListSamePosition(enno, enposition);
		
		
		if(recommendList.size() > 0) {
			
			String str;
			for(int i = 0; i < recommendList.size(); i++) {
				if(recommendList.get(i).getEntitle().length() > 20) {
					str = recommendList.get(i).getEntitle().substring(0, 20);
					recommendList.get(i).setEntitle(str + "...");
				}
			}
			
			model.addAttribute("recommendList", recommendList);
		}
		
		String mid = (String) session.getAttribute("mid");

		model.addAttribute("resume", resumedao.getMainResume(mid));

		int count = scrapdao.count(enno, mid);

		if (count >= 1) {
			model.addAttribute("scraptf", true);
		} else {
			model.addAttribute("scraptf", false);
		}

		return "employNoticeDetail_JYC";
	}

	@GetMapping("/detailCom")
	public String detailCom(@RequestParam("enno") Long enno, Model model) {

		model.addAttribute("employNoticeDto", employNoticeDao.getEmployNotice(enno));
		if (!degreeEmployNoticeDao.getDegreeEmployNoticeList(enno).isEmpty()) {
			model.addAttribute("degreeEmployNoticeList", degreeEmployNoticeDao.getDegreeEmployNoticeList(enno));
		}
		if (!experienceEmployNoticeDao.getExperienceEmployNoticeList(enno).isEmpty()) {
			model.addAttribute("experienceEmployNoticeList",
					experienceEmployNoticeDao.getExperienceEmployNoticeList(enno));
		}
		if (!skillEmployNoticeDao.getSkillEmployNoticeList(enno).isEmpty()) {
			model.addAttribute("skillEmployNoticeList", skillEmployNoticeDao.getSkillEmployNoticeList(enno));
		}
		if (!welfareEmployNoticeDao.getWelfareEmployNoticeList(enno).isEmpty()) {
			model.addAttribute("welfareEmployNoticeList", welfareEmployNoticeDao.getWelfareEmployNoticeList(enno));
		}
		if (!preferenceEmployNoticeDao.getPreferenceEmployNoticeList(enno).isEmpty()) {
			model.addAttribute("preferenceEmployNoticeList",
					preferenceEmployNoticeDao.getPreferenceEmployNoticeList(enno));
		}
		if (!certificateEmployNoticeDao.getCertificateEmployNoticeList(enno).isEmpty()) {
			model.addAttribute("certificateEmployNoticeList",
					certificateEmployNoticeDao.getCertificateEmployNoticeList(enno));
		}

		String enposition = employNoticeDao.getEmployNotice(enno).getEnposition();
		List<EmployNoticeDetail> recommendList = employNoticeDao.getEmployNoticeListSamePosition(enno, enposition);
		
		if(recommendList.size() > 0) {
			
			String str;
			for(int i = 0; i < recommendList.size(); i++) {
				if(recommendList.get(i).getEntitle().length() > 20) {
					str = recommendList.get(i).getEntitle().substring(0, 20);
					recommendList.get(i).setEntitle(str + "...");
				}
			}
			
			model.addAttribute("recommendList", recommendList);
		}
		
		return "employNoticeDetail_JYC";
	}

	@GetMapping("/scrap")
	public String scrap(@RequestParam("enno") Long enno, HttpSession session) {
		String mid = (String) session.getAttribute("mid");

		scrapdao.scrapEmployNotice(enno, mid);

		return "redirect:/employnotice/detailMem?enno=" + enno;
	}

	@GetMapping("/deleteScrap")
	public String deleteScrap(@RequestParam("enno") Long enno, HttpSession session) {
		String mid = (String) session.getAttribute("mid");

		scrapdao.unscrapEmployNotice(enno, mid);

		return "redirect:/employnotice/detailMem?enno=" + enno;
	}

	@PostMapping("/applyResume")
	public @ResponseBody String applyResume(@RequestBody ApplyResume ar, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html; charset=utf-8");
		
		int count = ardao.getCount(ar.getEnno(), ar.getRno());
		if(count > 0) {
			return "이미 지원된 채용공고입니다.";
		}else {
			ardao.applyResume(ar.getEnno(), ar.getRno());
			return "지원 완료 됬습니다!";
		}

	}
	
	@GetMapping("/changeOrder")
	public String changeOrder(@RequestParam("ordername") String order, Model model) {
		
		if(order.equals("enddate")) {
			model.addAttribute("employNoticeList", employNoticeDao.getAllEmployNoticeListOrderByEnddateAsc());
		}else if(order.equals("regdate")) {
			model.addAttribute("employNoticeList", employNoticeDao.getAllEmployNoticeListOrderByRegdateDesc());
		}
		return "employNoticeList_JYC";
	}
	
	@GetMapping("/changeOrderCompany")
	public String changeOrder(@RequestParam("ordername") String order, Model model, @RequestParam("cno") String cno) {
		
		if(order.equals("enddate")) {
			model.addAttribute("employNoticeList", employNoticeDao.getAllEmployNoticeListOrderByEnddateAscCno(cno));
		}else if(order.equals("regdate")) {
			model.addAttribute("employNoticeList", employNoticeDao.getAllEmployNoticeListOrderByRegdateDescCno(cno));
		}
		
		return "employNoticeList_JYC";
	}
	
	@PostMapping("/unscrap2")
	public String unscrap2(@RequestBody ScrapEmployNoticeDetail send, HttpSession session) {
		String mid = (String) session.getAttribute("mid");

		int count = scrapdao.count(send.getEnno(), mid);
		
		if(count > 0) {
			scrapdao.unscrapEmployNotice(send.getEnno(), mid);
		}else {
			scrapdao.scrapEmployNotice(send.getEnno(), mid);
		}

		return "";
	}

}
