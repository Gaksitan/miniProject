package com.green.miniProject.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.miniProject.dao.IQuestionCategoryDAO_JYC;
import com.green.miniProject.dao.IServiceQuestionDAO_JYC;
import com.green.miniProject.domain.ServiceQuestion;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/service")
public class ServiceController_JYC {
	
	@Autowired
	private IQuestionCategoryDAO_JYC qc;
	
	@Autowired
	private IServiceQuestionDAO_JYC sqdao;
	
	@GetMapping("/main")
	public String main() {
		return "serviceMainBoth_JYC";
	}
	
	@PostMapping("/registQuestionMem")
	public String registQuestionMem(ServiceQuestion sq, @RequestParam("category") String category, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		
		ServiceQuestion sqBuilder = ServiceQuestion.builder()
				.sqtitle(sq.getSqtitle())
				.sqcontent(sq.getSqcontent())
				.sqanswertf(false)
				.sqregdate(LocalDateTime.now())
				.mid((String)session.getAttribute("mid"))
				.qcno(qc.getQcno(category)).build();
		sqdao.registServiceQuestionMem(sqBuilder);
		
		log.info(sqBuilder);
		return "";
	}
	
	@PostMapping("/registQuestionCom")
	public String registQuestionCom(ServiceQuestion sq, @RequestParam("category") String category, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		ServiceQuestion sqBuilder = ServiceQuestion.builder()
				.sqtitle(sq.getSqtitle())
				.sqcontent(sq.getSqcontent())
				.sqanswertf(false)
				.sqregdate(LocalDateTime.now())
				.cno((String)session.getAttribute("cno"))
				.qcno(qc.getQcno(category)).build();
		sqdao.registServiceQuestionCom(sqBuilder);
		
		return "";
	}

}
