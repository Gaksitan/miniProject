package com.green.miniProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.miniProject.dao.ICompanyDao_PSH;
import com.green.miniProject.domain.Company;
import com.green.miniProject.domain.CompanyManager;
import com.green.miniProject.domain.DegreeEmployNotice;
import com.green.miniProject.domain.EmployNotice;
import com.green.miniProject.domain.ExperienceEmployNotice;
import com.green.miniProject.domain.SkillEmployNotice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

@Controller
public class ComController_PSH {
	
	@Autowired
	ICompanyDao_PSH dao;
	
	@Autowired
	HttpServletRequest request;
	
	@RequestMapping("/indexCom")
	public String indexCom() {
		
		return "indexCom_PSH";
	}
	
	@RequestMapping("/regFormCom")
	public String regFormCom() {
		
		return "regFormCom_PSH";
	}
	
	@Transactional
    @RequestMapping("/signUpCom")
    public String signUpCom(Company com, 
    						@RequestParam("cno") String cno,
                            @RequestParam("cmid") String cmid,
                            @RequestParam("cmpw") String cmpw,
                            @RequestParam("cmpw2") String cmpw2,
                            @RequestParam("cmemail") String cmemail,
                            @RequestParam("cmemail2") String cmemail2,
                            @RequestParam("cmtel") String cmtel) {

        if (!cmpw.equals(cmpw2)) {
            return "redirect:signUpComForm?error=passwordMismatch";
        }

        String fullEmail = cmemail + "@" + cmemail2;

        CompanyManager cm = new CompanyManager();
        cm.setCmid(cmid);
        cm.setCmpw(cmpw);
        cm.setCmemail(fullEmail);
        cm.setCmtel(cmtel);
        cm.setCno(cno);

        dao.insertCompany(com);
        dao.insertCompanyManager(cm);

        return "indexCom_PSH";
    }
	
	@RequestMapping("/loginFormCom")
	public String loginCom() {
		
		return "loginForm_PSH";
	}
	
	@RequestMapping("/loginCom")
	public String login(@RequestParam("cmid") String cmid, @RequestParam("cmpw") String cmpw, Model model) {
						
		CompanyManager cm = dao.select(cmid, cmpw);
		String msg="";
		if(cm == null) {
			msg = "회원정보가 없습니다.";
			model.addAttribute("msg", msg);
			return "loginFormCom";
		}else {
			HttpSession session = request.getSession();
			
			session.setAttribute("companyManager", cm);
			
	        Company company = dao.getCompanyByCno(cm.getCno());
	        session.setAttribute("company", company);
			
			return "redirect:indexCom";
			
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {

	    session.invalidate();
	    
	    return "redirect:/";
		
	
	}
	
	   @RequestMapping("/infoCom")
	    public String infoCom() {
	        return "infoCom_PSH";
	    }

	    @Transactional
	    @RequestMapping(value = "/updateComInfo", method = RequestMethod.POST)
	    public String updateComInfo(Company com) {
	        dao.updateComInfo(com);
	        return "redirect:indexCom";
	    }
	
	    @RequestMapping("/infoCM")
	    public String infoCM() {
	    	return "infoCompanyManager_PSH";
	    }

	    @Transactional
	    @RequestMapping(value = "/updateCMinfo", method = RequestMethod.POST)
	    public String updateCMInfo(CompanyManager cm) {
	    	dao.updateCMinfo(cm);
	    	return "redirect:indexCom";
	    }

	    
	    @RequestMapping("/employNotice")
		public String employNotice() {
			
			return "employNoticeSave_PSH";
		}	
	    
	    
	    @RequestMapping("/enwrite")
	    public String enWrite(EmployNotice en, 
	                           ExperienceEmployNotice experience,
	                           DegreeEmployNotice degree,
	                           SkillEmployNotice skill) {
	    	
	    	HttpSession session = request.getSession();
	        Company company = (Company)session.getAttribute("company");
	        
	        String cno = company.getCno();
	        
	        en.setCno(cno);
	        
	        dao.enwrite(en);
	        dao.insertExperience(experience);
	        dao.insertDegree(degree);
	        dao.insertSkill(skill);
	        return "redirect:indexCom";
	    }
}
