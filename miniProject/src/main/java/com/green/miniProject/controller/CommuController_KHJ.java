package com.green.miniProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.miniProject.dao.ICommuDao_KHJ;
import com.green.miniProject.domain.Board;
import com.green.miniProject.domain.Member;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/commu")
public class CommuController_KHJ {

	@Autowired
	private ICommuDao_KHJ dao;

	@RequestMapping("/")
	public String root(Model model) {

		String id = "개인회원";
		
		if (id.equals("개인회원")) {

			model.addAttribute("list", dao.getAllWhenMember());
			System.out.println(model.addAttribute("list", dao.getAllWhenMember()));
			
		} else if (id.equals("기업회원")) {

			model.addAttribute("list", dao.getAllWhenCompany());
		}

		return "community_KHJ";
	}

	@RequestMapping("/communityMemInsert_KHJ")
	public String communityMemInsert_KHJ() {
		
		
		
		return "communityMemInsert_KHJ";
	}
	
	@RequestMapping("/communityDetail_KHJ")
	public String communityDetail_KHJ(HttpServletRequest request, Model model) {
		
		  String sBno = request.getParameter("bno");
		  long bno = Long.parseLong(sBno);
		  List<Object> boardDetail = dao.detailDao(bno);

		  
		  model.addAttribute("detail", boardDetail);
		  return "communityDetail_KHJ";
		
	}
	
	//@RequestMapping("/view")
//	public String view(HttpServletRequest request, Model model) {
//
//		String btitle = request.getParameter("btitle");
//		model.addAttribute("list", dao.detailDao(btitle));
//		System.out.println(model.addAttribute("list", dao.detailDao(btitle)));
//		return "list";
//	}

}
