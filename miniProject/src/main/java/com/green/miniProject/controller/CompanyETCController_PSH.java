package com.green.miniProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.miniProject.dao.ICompanyETCDao_PSH;
import com.green.miniProject.domain.ApplyResume;
import com.green.miniProject.domain.Company;
import com.green.miniProject.domain.EmployNotice;
import com.green.miniProject.domain.InterestMember;
import com.green.miniProject.service.CompanyETCService_PSH;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CompanyETCController_PSH {

	@Autowired
	ICompanyETCDao_PSH dao;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
    private CompanyETCService_PSH service;

	@RequestMapping("/subscribeComList")
	public String subscribeComList(Model model) {
		
		List<InterestMember> allList = service.getAllInterestMembers();

        model.addAttribute("allList", allList);
		
		return "subscribeComList_PSH";
	}
	
    @GetMapping("/removeInterest")
    public String removeInterest(@RequestParam("imno") Long imno) {

    	service.removeInterest(imno);
    	
    	return "redirect:/subscribeComList";
    }
    //관심 구직자

    @GetMapping("/employNoticeList")
    public String getEmployNoticeList(Model model, HttpSession session) {
    	Company company = (Company)session.getAttribute("company");
    	
    	String cno = company.getCno();
    	
    	List<EmployNotice> employNoticeList = service.getEmployNoticesByCno(cno);
        
        model.addAttribute("employNoticeList", employNoticeList);
        return "employNoticeList_PSH";
    }
	
    @GetMapping("/applicantList")
    public String getApplicantList(Model model, HttpSession session) {
        Company company = (Company)session.getAttribute("company");
        
        String cno = company.getCno();
        
        List<ApplyResume> allList = service.getApplyResumesByCompany(cno);
        model.addAttribute("allList", allList);
		return "applicantList_PSH";
	}
	
	@RequestMapping("/applicantDetail")
	public String applicantDetail() {
		
		return "applicantDetail_PSH";
	}

	@RequestMapping("/applyResumeDetail")
	public String applyResumeDetail() {
		
		return "applyResumeDetail_PSH";
	}

}
