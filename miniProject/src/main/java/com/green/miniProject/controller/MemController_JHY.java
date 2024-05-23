package com.green.miniProject.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.green.miniProject.dao.IMemberDao_JHY;
import com.green.miniProject.domain.Certificate;
import com.green.miniProject.domain.CheckScrapEN;
import com.green.miniProject.domain.CheckSubscribeCom;
import com.green.miniProject.domain.Company;
import com.green.miniProject.domain.Degree;
import com.green.miniProject.domain.Experience;
import com.green.miniProject.domain.JoinApplyResumeList;
import com.green.miniProject.domain.JoinEmployNoticeAndCompany;
import com.green.miniProject.domain.Link;
import com.green.miniProject.domain.Member;
import com.green.miniProject.domain.Resume;
import com.green.miniProject.domain.Skill;
import com.green.miniProject.domain.SkillMatchingEN;
import com.green.miniProject.domain.SkillMatchingMR;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/mem")
public class MemController_JHY {
	
	@Autowired
	IMemberDao_JHY dao;
	
	// 스킬 매치 구현중
	@RequestMapping("/indexMem")
	public String indexMem(HttpSession session, Model model) {
		System.out.println(session.getAttribute("mid"));
		if(session.getAttribute("mid") == null) {
			
		}else if(session.getAttribute("mid") != null) {
			String mid = (String) session.getAttribute("mid");
			Member member = dao.getMember(mid);
			model.addAttribute("member", member);
			Set<SkillMatchingEN> total = new HashSet<>();
			List<SkillMatchingMR> list = dao.skillmatchingMR(mid);
			List<SkillMatchingEN> list2 = dao.skillmatchingEN();
			
			if(list.get(0).getRno() != null) {
				for(int i = 0; i < list.size(); i++) {
					for(int j = 0; j < list2.size(); j++) {
						if(list2.get(i).getSkname().equals( list.get(j).getSkname())) {
							SkillMatchingEN en = new SkillMatchingEN();
							en.setEnno(list2.get(j).getEnno());
							en.setEntitle(list2.get(j).getEntitle());
							en.setSkname(list2.get(j).getSkname());
							total.add(en);
							System.out.println(en.getEnno() + "/" + en.getEntitle() + "/" + total);
						}
					}
					
				}
			}else {
				
			}
			model.addAttribute("listMR", list);
			model.addAttribute("listEN", list2);
			model.addAttribute("total", total);
		}
		List<Company> list4 = dao.getCompanyList();
		System.out.println(list4);
		List<JoinEmployNoticeAndCompany> list3 = dao.getEmployNotice();
		System.out.println(list3);
		model.addAttribute("employNoticeList", list3);
		model.addAttribute("companyList", list4);
		
		return "indexMem_JHY";
	}
	
	@RequestMapping("/regFormMem")
	public String regFormMem() {
		
		return "regFormMem_JHY";
	}
	
	// 회원가입 버튼 클릭시 
	@RequestMapping("/regist")
	public String regist(HttpServletRequest request) {
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String memail = request.getParameter("memail");
		String mtel1 = request.getParameter("mtel1");
		String mtel2 = request.getParameter("mtel2");
		String mbirthDate_ = request.getParameter("mbirthDate");
		LocalDate mbirthDate = LocalDate.parse(mbirthDate_, DateTimeFormatter.ISO_LOCAL_DATE);
		String mname = request.getParameter("mname");
		String maddr1 = request.getParameter("maddr1");
		String maddr2 = request.getParameter("maddr2");
		LocalDate mregDate = LocalDate.now();
		int mstate = Integer.parseInt(request.getParameter("mstate"));
		String mgender = request.getParameter("mgender");
		Member member = new Member(mid, mpw, memail, mtel1, mtel2, mbirthDate, mname, maddr1, maddr2, mregDate, mstate, mgender);
		dao.regist(member);
		
		return "loginForm_JHY";
	}
	
	@RequestMapping("/regMidCheck")
	public @ResponseBody String regMidCheck(@RequestParam("mid") String mid) {
		
		Member member = dao.getMember(mid);
		String result = "";
		if(member == null) {
			result = "사용가능한 ID입니다.";
		}else {
			result = "이미 사용중인 ID입니다.";
		}
		
		return result;
	}
	
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		
		return "loginForm_JHY";
	}
	
	// 로그인 버튼 클릭시
	@RequestMapping("/login")
	public String login(@RequestParam("mid") String mid, @RequestParam("mpw") String mpw, Model model, HttpServletRequest request, HttpServletResponse response) {
		
		Member mem = dao.loginCheck(mid, mpw);
		boolean tf = false;
		if(mem != null) {
			if(mem.getMid().equals(mid) && mem.getMpw().equals(mpw)) {
				tf = true;
				model.addAttribute("tf", tf);
				HttpSession session = request.getSession();
				session.setAttribute("mem", mem);
				session.setAttribute("mid", mid);
				session.setAttribute("mpw", mpw);
				
				return "redirect:/mem/indexMem";
			}else {
				
			}
		}
		
		model.addAttribute("tf", tf);
		return "loginForm_JHY";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "indexMem_JHY";
	}
	
	// 내 이력서 목록 페이지
	@RequestMapping("/myResumeList")
	public String myResumeList(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("mid");
		List<Resume> myResumeList = dao.getResumeList(mid);
		model.addAttribute("myResumeList", myResumeList);
		return "myResumeList_JHY";
	}
	
	// 내 이력서 상세보기 페이지
	@RequestMapping("/myResumeDetail")
	public String myResumeDetail(@RequestParam("rno") Long rno, Model model) {
		if(rno != null) {
			Resume resume = dao.getResume(rno);
			String mid = resume.getMid();
			Member mem = dao.getMember(mid);
			model.addAttribute("resume", resume);
			model.addAttribute("member", mem);
			List<Skill> skill = dao.getResumeSkillList(rno);
			List<Degree> degree = dao.getResumeDegreeList(rno);
			List<Experience> experience = dao.getResumeExperienceList(rno);
			List<Certificate> certificate = dao.getResumeCertificateList(rno);
			List<Link> link = dao.getResumeLinkList(rno);
			model.addAttribute("skillList", skill);
			model.addAttribute("degreeList", degree);
			model.addAttribute("experienceList", experience);
			model.addAttribute("certificateList", certificate);
			model.addAttribute("linkList", link);
		}else {
			
		}
		return "myResumeDetail_JHY";
	}
	
	@RequestMapping("/myResumeDetailWrite")
	public String myResumeDetailUpdate(HttpSession session, Model model) {
		String mid = (String) session.getAttribute("mid");
		Member mem = dao.getMember(mid);
		model.addAttribute("member", mem);
		return "myResumeDetail_JHY";
	}
	
	
	// 이력서 작성(rno == null)
	@RequestMapping("/writeResume")
	public String writeResume(HttpServletRequest request, @RequestParam("rskill") List<Skill> rskill, @RequestParam("rexp") List<Experience> rexp) {
		HttpSession session = request.getSession();
		String mid = (String) session.getAttribute("mid");
		
		String rintro = request.getParameter("rintro");
		String rimgPath = request.getParameter("rimgPath");
		String rpublic_ = request.getParameter("rpublic");
		boolean rpublic;
		if(rpublic_ == "true") {
			rpublic = true;
		}else {
			rpublic = false;
		}
		String rtitle = request.getParameter("rimgPath");
		String rmain_ = request.getParameter("rimgPath");
		boolean rmain;
		if(rmain_ == "true") {
			rmain = true;
		}else {
			rmain = false;
		}
		LocalDate rregdate = LocalDate.now();
		Resume resume = new Resume(null, mid, rintro, rimgPath, rpublic, rtitle, rmain, rregdate);
		dao.writeResume(resume);
		
		return "myResumeList_JHY";
	}
	
	// 이력서 수정(rno != null)
	@RequestMapping("/updateResume")
	public String updateResume(HttpServletRequest request) {
		String rno_ = request.getParameter("rno");
		Long rno = Long.parseLong(rno_);
		Resume resume = dao.getResume(rno);
		String mid = resume.getMid();
		String rintro = request.getParameter("rintro");
		String rimgPath = request.getParameter("rimgPath");
		String rpublic_ = request.getParameter("rpublic");
		Boolean rpublic;
		if(rpublic_ == "true") {
			rpublic = true;
		}else {
			rpublic = false;
		}
		String rtitle = request.getParameter("rtitle");
		String rmain_ = request.getParameter("rmain");
		Boolean rmain;
		if(rmain_ == "true") {
			rmain = true;
		}else {
			rmain = false;
		}
		LocalDate rregdate = LocalDate.now();
		Resume updateResume = new Resume(rno, mid, rintro, rimgPath, rpublic, rtitle, rmain, rregdate);
		dao.updateResume(updateResume);
		return "myResumeList_JHY";
	}
	
	
	@RequestMapping("/myApplyList")
	public String myApplyList(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String mid = (String) session.getAttribute("mid");
		List<JoinApplyResumeList> list = dao.applyResumeList(mid);
		model.addAttribute("myApplyList", list);
		
		return "myApplyList_JHY";
	}
	
	
	@RequestMapping("/infoMem")
	public String infoMem(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String mid = (String) session.getAttribute("mid");
		Member mem = dao.getMember(mid);
		model.addAttribute("member", mem);
		
		return "infoMem_JHY";
	}
	
	
	@RequestMapping("/updateMemberInfo")
	public String updateMemberInfo(HttpServletRequest request, Model model) {
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String maddr1 = request.getParameter("maddr1");
		String maddr2 = request.getParameter("maddr2");
		String mtel1 = request.getParameter("mtel1");
		String mtel2 = request.getParameter("mtel2");
		int mstate = Integer.parseInt(request.getParameter("mstate"));
		String mgender = request.getParameter("mgender");
		Member member = new Member(mid, mpw, mname, maddr1, maddr2, mtel1, mtel2, mstate, mgender);
		dao.updateMember(member);
		return "indexMem_JHY";
	}
	
	@RequestMapping("/deleteMemInfo")
	public String deleteMemInfo(HttpSession session) {
		String mid = (String) session.getAttribute("mid");
		dao.deleteMember(mid);
		
		return "redirect:/mem/indexMem";
	}
	
	
	
	@RequestMapping("/subscribeAndScrapList")
	public String subscribeAndScrapList(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String mid = (String) session.getAttribute("mid");
		List<CheckSubscribeCom> list = dao.checkSubscribe(mid);
		List<CheckScrapEN> list2 = dao.checkScrap(mid);
		model.addAttribute("subscribeList", list);
		model.addAttribute("scrapList", list2);
		return "subscribeAndScrapList_JHY";
	}
	
	
	
	
	
}
