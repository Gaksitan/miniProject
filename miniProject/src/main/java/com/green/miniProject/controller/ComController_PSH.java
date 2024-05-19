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
import com.green.miniProject.domain.EmployNotice;

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

        dao.insertCompany(com);
        dao.insertCompanyManager(cm);

        return "redirect:loginForm_PSH";
    }
	
	@RequestMapping("/loginFormCom")
	public String loginCom() {
		
		return "loginForm_PSH";
	}
	
	@RequestMapping("/loginCom") //로그인 기능
	public String login(@RequestParam("cmid") String cmid, @RequestParam("cmpw") String cmpw, Model model) {
						
		CompanyManager cm = dao.select(cmid, cmpw);
		String msg="";
		if(cm == null) {
			msg = "회원정보가 없습니다.";
			model.addAttribute("msg", msg);
			return "loginFormCom";
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("cmid",cm.getCmid());
			session.setAttribute("cmpw",cm.getCmpw());
			session.setAttribute("cmname",cm.getCmname());
			
			return "redirect:/";
			
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
        return "redirect:infoCom_PSH?success";
    }
	
	@RequestMapping("/infoCompanyManager")
	public String infoCM() {
		
		return "infoCompanyManager_PSH";
	}
	
    @RequestMapping(value = "/updateCMinfo", method = RequestMethod.POST)
    public String updateCMInfo(CompanyManager cm) {

    	if (cm.getCmpw().equals(cm.getCheckCmpw())) {
            dao.updateCMInfo(cm);
            return "redirect:infoCompanyManager_PSH?success";
        } else {
            return "redirect:infoCompanyManager_PSH?error";
        }
    }
	
	@RequestMapping("/employNoticeSave")
	public String employNoticeSave() {
		
		return "employNoticeSave_PSH";
	}
	
	@RequestMapping("/enwrite")
	public String enWrite(EmployNotice em) {
		
		dao.enwrite(em);
		
		return "redirect:";
	}
}
