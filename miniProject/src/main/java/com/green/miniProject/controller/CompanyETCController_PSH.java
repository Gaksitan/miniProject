package com.green.miniProject.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        
        Map<Long, Integer> applicantCounts = employNoticeList.stream()
                .collect(Collectors.toMap(
                    EmployNotice::getEnno,
                    notice -> {
                        Integer count = service.getApplyCountByEnno(notice.getEnno());
                        return count != null ? count : 0;
                    }
                ));
    	
        model.addAttribute("employNoticeList", employNoticeList);
        model.addAttribute("applicantCounts", applicantCounts);
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

        int age = service.calculateAge(applicantDetail.getMbirthDate());
        
        model.addAttribute("item", applicantDetail);
        model.addAttribute("age", age);
        model.addAttribute("resumeList", resumeList);

        return "applicantDetail_PSH";
    }
    //지원자 상세보기
    
    @PostMapping("/submitScore")
    @ResponseBody
    public String submitScore(@RequestParam("mid") String mid,
                              @RequestParam("cno") String cno,
                              @RequestParam("score") int score,
                              @RequestParam("review") String review) {
        try {
            service.submitScore(mid, cno, score, review);
            return "success";
        } catch (Exception e) {
            return "failure";
        }
    }
    //평점 남기기
    
    


    @GetMapping("/applyResumeDetail")
	public String applyResumeDetail(@RequestParam("rno") String rno, @RequestParam("mid") String mid, Model model) {
    	Member applicantDetail = service.getApplicantDetailByMid(mid);
    	Resume resumeDetail = service.getResumeByRno(rno);
        List<Skill> skillList = service.getSkillListByRno(rno);
        List<Experience> expList = service.getExperienceListByRno(rno);
        List<Degree> degreeList = service.getDegreeListByRno(rno);
        List<Link> linkList = service.getLinkListByRno(rno);
        

        model.addAttribute("item", applicantDetail);
        model.addAttribute("resume", resumeDetail);
        model.addAttribute("skillList", skillList);
        model.addAttribute("expList", expList);
        model.addAttribute("degreeList", degreeList);
        model.addAttribute("linkList", linkList);
    	
    	
		return "applyResumeDetail_PSH";
	}
	//이력서 상세보기
    
    @PostMapping("/updateApplicationStatus")
    public ResponseEntity<String> updateApplicationStatus(@RequestParam("status") int status, @RequestParam("rno") String rno) {
        try {
            dao.updateApplicationStatus(status, rno);
            return ResponseEntity.ok("Status updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating status");
        }
    }
    // 서류 평가

}
