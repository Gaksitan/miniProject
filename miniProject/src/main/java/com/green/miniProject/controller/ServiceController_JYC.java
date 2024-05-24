package com.green.miniProject.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.miniProject.dao.IFAQDAO_JYC;
import com.green.miniProject.dao.IQuestionCategoryDAO_JYC;
import com.green.miniProject.dao.IServiceAnswerDAO_JYC;
import com.green.miniProject.dao.IServiceQuestionDAO_JYC;
import com.green.miniProject.domain.CompanyManager;
import com.green.miniProject.domain.FAQ;
import com.green.miniProject.domain.FAQDetail;
import com.green.miniProject.domain.ServiceQuestion;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/service")
public class ServiceController_JYC {
	
	@Autowired
	private IQuestionCategoryDAO_JYC qcdao;
	
	@Autowired
	private IServiceQuestionDAO_JYC sqdao;
	
	@Autowired
	private IFAQDAO_JYC faqdao;
	
	@Autowired
	private IServiceAnswerDAO_JYC sadao;
	
	@GetMapping("/mainMem")
	public String mainMem(Model model) {
		
		List<FAQDetail> faqlist = faqdao.getFAQListTargetMem();
		String str;
		for(int i = 0; i < faqlist.size(); i++) {
			if(faqlist.get(i).getFaqquestion().length() > 30) {
				str = faqlist.get(i).getFaqquestion().substring(0, 30);
				faqlist.get(i).setFaqquestion(str + "...");
			}
		}
		
		model.addAttribute("faqlist", faqlist);
		
		return "serviceMainBoth_JYC";
	}
	
	@GetMapping("/mainCom")
	public String mainCom(Model model) {
		
		List<FAQDetail> faqlist = faqdao.getFAQListTargetCom();
		String str;
		for(int i = 0; i < faqlist.size(); i++) {
			if(faqlist.get(i).getFaqquestion().length() > 30) {
				str = faqlist.get(i).getFaqquestion().substring(0, 30);
				faqlist.get(i).setFaqquestion(str + "...");
			}
		}
		
		model.addAttribute("faqlist", faqlist);
		
		return "serviceMainBoth_JYC";
	}
	
	@PostMapping("/registQuestionMem")
	public String registQuestionMem(ServiceQuestion sq, @RequestParam("qcno") Long qcno, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		ServiceQuestion sqBuilder = ServiceQuestion.builder()
				.sqtitle(sq.getSqtitle())
				.sqcontent(sq.getSqcontent())
				.sqanswertf(false)
				.sqregdate(LocalDateTime.now())
				.mid((String)session.getAttribute("mid"))
				.qcno(qcno)
				.build();
		sqdao.registServiceQuestionMem(sqBuilder);
		
		return "redirect:/service/myQuestionMem";
	}
	
	@PostMapping("/registQuestionCom")
	public String registQuestionCom(ServiceQuestion sq, @RequestParam("category") String category, HttpSession session) {
		
		CompanyManager companyManager = (CompanyManager)session.getAttribute("companyManager");
		
		ServiceQuestion sqBuilder = ServiceQuestion.builder()
				.sqtitle(sq.getSqtitle())
				.sqcontent(sq.getSqcontent())
				.sqanswertf(false)
				.sqregdate(LocalDateTime.now())
				.cno(companyManager.getCno())
				.qcno(qcdao.getQcno(category)).build();
		sqdao.registServiceQuestionCom(sqBuilder);
		return "redirect:/service/myQuestionCom";
	}
	
	@GetMapping("/searchMem")
	public String searchMem(@RequestParam("keyword") String keyword, Model model) {
		
		model.addAttribute("faqlist", faqdao.searchFAQListTargetMem(keyword));
		
		return "serviceSearchResult_JYC";
	}
	
	@GetMapping("/searchCom")
	public String searchCom(@RequestParam("keyword") String keyword, Model model) {
		
		model.addAttribute("faqlist", faqdao.searchFAQListTargetCom(keyword));
		return "serviceSearchResult_JYC";
	}
	
	@GetMapping("/myQuestionMem")
	public String myquestionMem(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("mid");
		
		List<ServiceQuestion> sqlist = sqdao.getServiceQuestionListForMem(mid);
		String str;
		if(!sqlist.isEmpty()) {
			for(int i = 0; i < sqlist.size(); i++) {
				if(sqlist.get(i).getSqtitle().length() > 10) {
					str = sqlist.get(i).getSqtitle().substring(0, 10);
					sqlist.get(i).setSqtitle(str + "...");
				}
				
				if(sqlist.get(i).getSqcontent().length() > 20) {
					str = sqlist.get(i).getSqcontent().substring(0, 20);
					sqlist.get(i).setSqcontent(str + "...");
				}
			}
			model.addAttribute("serviceQuestionList", sqlist);
		}

		return "myServiceQuestion_JYC";
	}
	
	@GetMapping("/myQuestionCom")
	public String myQuestionCom(HttpSession session, Model model) {
		
		
		CompanyManager companyManager = (CompanyManager)session.getAttribute("companyManager");
		
		List<ServiceQuestion> sqlist = sqdao.getServiceQuestionListForCom(companyManager.getCno());
		String str;
		if(!sqlist.isEmpty()) {
			for(int i = 0; i < sqlist.size(); i++) {
				if(sqlist.get(i).getSqtitle().length() > 10) {
					str = sqlist.get(i).getSqtitle().substring(0, 10);
					sqlist.get(i).setSqtitle(str + "...");
				}
				
				if(sqlist.get(i).getSqcontent().length() > 20) {
					str = sqlist.get(i).getSqcontent().substring(0, 20);
					sqlist.get(i).setSqcontent(str + "...");
				}
			}
			model.addAttribute("serviceQuestionList", sqlist);
		}
		
		return "myServiceQuestion_JYC";
	}
	
	@GetMapping("/serviceQuestionDetail")
	public String serviceQuestionDetail(@RequestParam("sqno") Long sqno, Model model) {
		
		ServiceQuestion serviceQuestion = sqdao.getServiceQuestion(sqno);
		
		model.addAttribute("sq", serviceQuestion);
		model.addAttribute("category", qcdao.getQcname(serviceQuestion.getQcno()));
		
		if (serviceQuestion.isSqanswertf()) {
			model.addAttribute("answer", sadao.getSacontent(sqno));
		}
		
		return "myServiceQuestionDetail_JYC";
		
	}
	
	@GetMapping("/deleteServiceQuestionMem")
	public String deleteServiceQuestionMem(@RequestParam("sqno") Long sqno) {
		
		sqdao.deleteServiceQuestion(sqno);
		
		return "redirect:/service/myQuestionMem";
	}
	
	@GetMapping("/deleteServiceQuestionCom")
	public String deleteServiceQuestionCom(@RequestParam("sqno") Long sqno) {
		
		sqdao.deleteServiceQuestion(sqno);
		
		return "redirect:/service/myQuestionCom";
	}
	
	@GetMapping("/faqDetail")
	public String faqDetail(@RequestParam("faqno") Long faqno, Model model) {
		
		model.addAttribute("faqDto" , faqdao.getFAQDetail(faqno));
		
		return "faqDetail_JYC";
		
	}
	
}
