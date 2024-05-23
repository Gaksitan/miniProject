package com.green.miniProject.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.miniProject.dao.ICompanyDAO_JYC;
import com.green.miniProject.dao.ICompanySectorDAO_JYC;
import com.green.miniProject.dao.IScrapEmployNoticeDAO_JYC;
import com.green.miniProject.dao.ISubscribeCompanyDAO_JYC;
import com.green.miniProject.domain.ScrapEmployNoticeDetail;
import com.green.miniProject.domain.SubscribeCompanyDetail;

import jakarta.servlet.http.HttpSession;
import lombok.Builder;

@Controller
@Builder
@RequestMapping("/member")
public class MemberController_JYC {

	@Autowired
	private ISubscribeCompanyDAO_JYC subComDao;
	
	@Autowired
	private IScrapEmployNoticeDAO_JYC scrapEnDao;
	
	@Autowired
	private ICompanySectorDAO_JYC comSecDao;
	
	@Autowired
	private ICompanyDAO_JYC comDao;
	
	@GetMapping("/subscribeAndScrapList")
	public String subscribeAndScrapList(HttpSession session, Model model) {
		
		String mid = (String)session.getAttribute("mid");
		
		
		
		List<SubscribeCompanyDetail> scdlist = subComDao.getSubComDetail(mid);
		
		List<Object> scnameList = new ArrayList<>();
		for(SubscribeCompanyDetail s : scdlist) {
			scnameList.add(comSecDao.getScnameList(s.getCno()));
		}
		
		
		
		if(scdlist.size() > 0) {
			model.addAttribute("subscribeList", scdlist);
		}
		
		List<ScrapEmployNoticeDetail> scrapList = scrapEnDao.getScrapENDetail(mid);

		if(scnameList.size() > 0) {
			model.addAttribute("scnameList", scnameList);
		}
		
		for(int i = 0; i < scrapList.size(); i++) {
			scrapList.get(i).setCname(comDao.getCname(scrapList.get(i).getCno()));
		}
		
		if(scrapList.size() > 0) {
			model.addAttribute("scrapList", scrapList);
		}
		
		return "subscribeAndScrapList_JHY";
	}
}
