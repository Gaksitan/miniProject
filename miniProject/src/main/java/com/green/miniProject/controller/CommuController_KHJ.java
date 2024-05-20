package com.green.miniProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.miniProject.dao.ICommuDao_KHJ;
import com.green.miniProject.domain.Board;
import com.green.miniProject.domain.Member;
import com.green.miniProject.domain.Notice;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/commu")
public class CommuController_KHJ {

	@Autowired
	private ICommuDao_KHJ dao;
	
	
	//리퀘스트 매핑 수정 => /commu 입력 시 이동되게! (송이)
	@RequestMapping("")
	public String root(Model model) {

		String id = "개인회원";
		
		if (id.equals("개인회원")) {

			model.addAttribute("list", dao.getAllWhenMember());
			System.out.println(model.addAttribute("list", dao.getAllWhenMember()));
			
		} else if (id.equals("기업회원")) {

			model.addAttribute("list", dao.getAllWhenCompany());
		}

		// 공지사항 리스트 불러오기
		List<Notice> noticeList = dao.getNoticeList();
		model.addAttribute("noticeList",noticeList);
		
		
		
		return "community_KHJ";
	}

	
	//공지사항 상세페이지
	@RequestMapping("/communityNotice_MSI")
	public String communityNotice_MSI(@RequestParam("nno") String nno, Model model) {
		model.addAttribute("notice",dao.getNoticeDetail(nno));
		
		return "communityNotice_MSI";
		
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
