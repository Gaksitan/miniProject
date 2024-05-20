package com.green.miniProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.miniProject.dao.ICompanyETCDao_PSH;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CompanyETCController_PSH {

	@Autowired
	ICompanyETCDao_PSH dao;
	
	@Autowired
	HttpServletRequest request;
	
	@RequestMapping("/subscribeComList")
	public String subscribeComList() {
		
		return "subscribeComList_PSH";
	}

	
	@RequestMapping("/employNoticeList")
	public String employNoticeList() {
		
		return "employNoticeList_PSH";
	}
	
	@RequestMapping("/applicantList")
	public String applicantList() {
		
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
