package com.green.miniProject.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.green.miniProject.dao.IAdminDao_MSI;
import com.green.miniProject.dao.ICommuDao_KHJ;
import com.green.miniProject.domain.Admin;
import com.green.miniProject.domain.BlackAccount;
import com.green.miniProject.domain.FAQ;
import com.green.miniProject.domain.Notice;
import com.green.miniProject.domain.ServiceQuestion;

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
	public String login(HttpServletRequest request, Model model,RedirectAttributes redirectAttributes) {
		//관리자용 로그인 기능
		String ano = request.getParameter("ano");
		String aid = request.getParameter("aid");
		String apw = request.getParameter("apw");
		
		HttpSession session = request.getSession();
		
		List<Admin> adminList = adminDao.getAdminDao(aid);
		
        // 입력 값 검증
        if (ano == null || aid == null || apw == null || ano.isEmpty() || aid.isEmpty() || apw.isEmpty()) {
            redirectAttributes.addFlashAttribute("errorMessage", "모든 필드를 입력해주세요.");
            return "redirect:/admin/loginFormAdmin";
        }


        // 어드민 계정 데이터 가져오기
        if (adminList.isEmpty()) {
            redirectAttributes.addFlashAttribute("errorMessage", "존재하지 않는 관리자 ID입니다.");
            return "redirect:/admin/loginFormAdmin";
        }
        
        
        
        Admin admin = adminList.get(0);
        String aAno = admin.getAno();
        String aAid = admin.getAid();
        String aApw = admin.getApw();

        // 비밀번호 검증
        if (aAno.equals(ano) && aAid.equals(aid) && aApw.equals(apw)) {
            session.setAttribute("admin", admin);
            session.setAttribute("ano", ano);
            session.setAttribute("aid", aid);

            System.out.println(admin.toString());
            // 로그인 성공 시 관리자용 인덱스 페이지 이동
            return "indexAdmin_MSI";
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "계정 로그인에 실패했습니다. 다시 입력해주세요");
            return "redirect:/admin/loginFormAdmin";
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
	
	
	//고객센터 답변없는 질문목록(리스트)
	@RequestMapping("/serviceQuestionNoAnswer")
	public String serviceQuestionNoAnswer(Model model) {
		
		List<ServiceQuestion> list = adminDao.noAnswerList();
		model.addAttribute("list",list);
		
		return "serviceQuestionNoAnswer_MSI";
	}
	
	
	
	//고객센터 질문 답변 작성 페이지
	@RequestMapping("/serviceQuestionAnswer")
	public String serviceQuestionAnswer() {
	
		return "serviceQuestionAnswer_MSI";
	}
	
	
	//고객센터 관리자 답변 등록
	@RequestMapping("/serviceAnswer")
	public String serviceAnswer(HttpServletRequest request) {
		
		String sqno = request.getParameter("sqno");
		
		String sacontent = request.getParameter("sacontent");
		
		LocalDate saregdate = LocalDate.now();

		adminDao.writeServiceAnswer(sqno,sacontent,saregdate);
		
		return "serviceQuestionNoAnswer_MSI";
	}
	
	
	//FAQ 관리페이지
	@RequestMapping("/serviceFAQ")
	public String serviceFAQ(Model model) {
		List<FAQ> faqList = adminDao.getFaqList();
		
		model.addAttribute("faqList",faqList);
		//member, company
		return "serviceFAQ_MSI";
	}
	
	
	//FAQ 작성 페이지
	@RequestMapping("/serviceFAQWrite")
	public String serviceFAQWrite() {
		
		return "serviceFAQWrite_MSI";
	}
	
	
	//FAQ 테이블 삽입
	@RequestMapping("/writeFAQ")
	public String writeFAQ(HttpServletRequest request) {
		String qcno_ = request.getParameter("qcno");
		Long qcno = Long.parseLong(qcno_);
		String faqtitle = request.getParameter("faqtitle");
		String faqquestion = request.getParameter("faqquestion");
		String faqanswer = request.getParameter("faqanswer");
		String faqtarget = request.getParameter("faqtarget");
		
		FAQ faq = new FAQ(faqquestion,faqanswer,qcno,faqtitle,faqtarget);
		int result = adminDao.writeFAQ(faq);
		
		return "redirect:/admin/serviceFAQ";
	}
	
	
	
	//블랙리스트 데이터 불러오기
	@RequestMapping("/blackList")
	public String blackList(Model model) {
		List<BlackAccount> blackList = adminDao.getBlackList();
		model.addAttribute("blackList",blackList);
		
		return "blackList_MSI";
	}
	
	
	//블랙리스트 차단 해제
	@RequestMapping("/unblock")
	public String unblock(HttpServletRequest request) {
		String bano = request.getParameter("bano");
		
		int result = adminDao.deleteBlackList(bano);
		
		if(result==1) {
			System.out.println("블랙리스트 차단 해제 성공");
		}else {
			System.out.println("블랙리스트 차단 해제 실패");
		}
		
		
		return "redirect:/admin/blackList";
	}
	
	
	
	
	
	
	
	
}











