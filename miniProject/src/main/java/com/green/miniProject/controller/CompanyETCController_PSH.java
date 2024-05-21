package com.green.miniProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.green.miniProject.dao.ICompanyETCDao_PSH;
import com.green.miniProject.domain.ApplyResume;
import com.green.miniProject.domain.Company;
import com.green.miniProject.domain.Degree;
import com.green.miniProject.domain.EmployNotice;
import com.green.miniProject.domain.Experience;
import com.green.miniProject.domain.InterestMember;
import com.green.miniProject.domain.Link;
import com.green.miniProject.domain.Member;
import com.green.miniProject.domain.Resume;
import com.green.miniProject.domain.Skill;
import com.green.miniProject.service.CompanyETCService_PSH;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CompanyETCController_PSH {

	@Autowired
	ICompanyETCDao_PSH dao;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
    private CompanyETCService_PSH service;

	@RequestMapping("/subscribeComList")
	public String subscribeComList(Model model) {
		
		List<InterestMember> allList = service.getAllInterestMembers();

        model.addAttribute("allList", allList);
		
		return "subscribeComList_PSH";
	}
	
    @GetMapping("/removeInterest")
    public String removeInterest(@RequestParam("imno") Long imno) {

    	service.removeInterest(imno);
    	
    	return "redirect:/subscribeComList";
    }
    //관심 구직자

    @GetMapping("/employNoticeList")
    public String getEmployNoticeList(Model model, HttpSession session) {
    	Company company = (Company)session.getAttribute("company");
    	
    	String cno = company.getCno();
    	    	    	
    	List<EmployNotice> employNoticeList = service.getEmployNoticesByCno(cno);
        
        model.addAttribute("employNoticeList", employNoticeList);
        return "employNoticeList_PSH";
    }
	


    @GetMapping("/applicantList")
    public String getApplicantList(Model model, HttpSession session) {
        Company company = (Company) session.getAttribute("company");

        if (company != null) {
            String cno = company.getCno();
            List<ApplyResume> allList = service.getApplyResumesByCompany(cno);
            model.addAttribute("allList", allList);
        }

        return "applicantList_PSH";
    }
    	
    @PostMapping("/toggleInterest")
    @ResponseBody
    public String toggleInterest(@RequestParam("mid") String mid, HttpSession session) {
        Company company = (Company) session.getAttribute("company");

        if (company != null) {
            String cno = company.getCno();
            boolean isInterested = service.toggleInterest(cno, mid);
            return isInterested ? "added" : "removed";
        }

        return "error";
    }
    //구독버튼
	
    @GetMapping("/applicantDetail")
    public String showApplicantDetail(@RequestParam("mid") String mid, Model model) {
        Member applicantDetail = service.getApplicantDetailByMid(mid);
        List<Resume> resumeList = service.getResumeListByMid(mid);

        model.addAttribute("item", applicantDetail);
        model.addAttribute("resumeList", resumeList);

        return "applicantDetail_PSH";
    }
    //지원자 상세보기



    @GetMapping("/applyResumeDetail")
	public String applyResumeDetail(@RequestParam("mid") String mid, Model model) {
    	Member applicantDetail = service.getApplicantDetailByMid(mid);
        List<Skill> skillList = service.getSkillListByMid(mid);
        List<Experience> expList = service.getExperienceListByMid(mid);
        List<Degree> degreeList = service.getDegreeListByMid(mid);
        List<Link> linkList = service.getLinkListByMid(mid);
        

        model.addAttribute("item", applicantDetail);
        model.addAttribute("skillList", skillList);
        model.addAttribute("expList", expList);
        model.addAttribute("degreeList", degreeList);
        model.addAttribute("linkList", linkList);
    	
    	
		return "applyResumeDetail_PSH";
	}
	//이력서 상세보기

}
