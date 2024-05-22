package com.green.miniProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.miniProject.dao.IScrapEmployNoticeDAO_JYC;
import com.green.miniProject.dao.ISubscribeCompanyDAO_JYC;
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
	
	@GetMapping("/subscribeAndScrapList")
	public String subscribeAndScrapList(HttpSession session, Model model) {
		
		String mid = (String)session.getAttribute("mid");
		
		List<SubscribeCompanyDetail> scdlist = subComDao.getSubComDetail("222");
		
		System.out.println(scdlist);
		
		if(scdlist.size() > 0) {
			model.addAttribute("scdlist", scdlist);
		}
		
		
		return "";
	}
}
