package com.green.miniProject.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.miniProject.dao.IAdminDao_MSI;
import com.green.miniProject.dao.ICommuDao_KHJ;
import com.green.miniProject.domain.Admin;
import com.green.miniProject.domain.Notice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequestMapping("/admin")
@Controller
public class AdminController_MSI {
	
	@Autowired
	private IAdminDao_MSI adminDao;
	
	@Autowired
	private ICommuDao_KHJ commuDao;
	
	
	
	@RequestMapping("/indexadmin")
	public String indexadmin() {
		//관리자용 인덱스 페이지
		return "indexAdmin_MSI";
	}
	
	
	@RequestMapping("/loginFormAdmin")
	public String loginFormAdmin() {
		//관리자용 로그인페이지
		return "loginFormAdmin_MSI";
	}
	
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model) {
		//관리자용 로그인 기능
		String ano = request.getParameter("ano");
		String aid = request.getParameter("aid");
		String apw = request.getParameter("apw");
		
		HttpSession session = request.getSession();
		
		//어드민 계정 데이터 가져오기
		List<Admin> admin = adminDao.adminDao(aid);
		String aAno = admin.get(0).getAno();
		String aAid = admin.get(0).getAid();
		String aApw = admin.get(0).getApw();
		
		
		if(aAno.equals(ano)&&aAid.equals(aid)&&aApw.equals(apw)) {
			session.setAttribute("admin", admin);
			session.setAttribute("ano", ano);
			session.setAttribute("aid", aid);
			
			System.out.println(admin.toString());
			//로그인 성공 시 관리자용 인덱스 페이지 이동
			return "indexAdmin_MSI";
		}else{
			model.addAttribute("계정 로그인이 틀렸습니다. 다시 입력해주세요");
			return "loginFormAdmin_MSI";
		}
		

	}
	
	
	@RequestMapping("/infoAdmin")
	public String infoAdmin(HttpServletRequest request, Model model) {
		//관리자용 공지사항 작성,수정 페이지 이동
		
		String nno = request.getParameter("nno");
		
		if(nno != null) {
			model.addAttribute("notice",commuDao.getNoticeDetail(nno));
		}
		
		return "infoAdmin_MSI";
	}
	
	
	
	
	//공지사항 내용 테이블 삽입
	@RequestMapping("/writeNotice")
	public String writeNotice(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		String ano = (String)session.getAttribute("ano");
		
		LocalDate nregdate_ = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String nregdate = nregdate_.format(formatter);
		
		adminDao.writeNotice(ano,request.getParameter("ntitle"),request.getParameter("ncontent"), nregdate);
		
		
		return "/admin/indexAdmin_MSI";
		
	}
	
	
	
	//공지사항 내용 테이블 수정
	@RequestMapping("/updateNotice")
	public String updateNotice(HttpServletRequest request) {
		String nno_ = request.getParameter("nno");
		Long nno = Long.parseLong(nno_);
		
		String ano = request.getParameter("ano");
		String ntitle = request.getParameter("ntitle");
		String ncontent = request.getParameter("ncontent");
		
		//수정된 현재 날짜
		LocalDate nregdate = LocalDate.now();
		
		
		Notice notice = new Notice(nno,ano,ntitle,ncontent,nregdate);
		
		int result = adminDao.updateNotice(notice);
		
		
		if(result==1) {
			System.out.println("공지 수정 성공");
		}else {
			System.out.println("공지 수정 실패");
		}
		
		return "indexAdmin_MSI";
	}
	
	
	
	//공지사항 내용 테이블 삭제
	@RequestMapping("/deleteNotice")
	public String deleteNotice(@RequestParam("nno")String nno) {
		int result = adminDao.deleteNotice(nno);
		
		if(result==1) {
			System.out.println("공지 삭제 성공");
		}else {
			System.out.println("공지 삭제 실패");
		}
		
		return "indexAdmin_MSI";
	}
	
	
	
}
