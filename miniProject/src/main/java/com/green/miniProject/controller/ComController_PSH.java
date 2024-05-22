package com.green.miniProject.controller;

import java.util.List;

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
import com.green.miniProject.domain.SkillEmployNotice;
import com.green.miniProject.domain.WelfareEmployNotice;
import com.green.miniProject.service.CompanyService_PSH;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

@Controller
public class ComController_PSH {
	
	@Autowired
	ICompanyDao_PSH dao;
	
	@Autowired
	CompanyService_PSH service;
	
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
	    public String employNotice(@RequestParam(value = "enno", required = false) Long enno, Model model) {
	        if (enno != null) {
	            EmployNotice employNotice = dao.getEmployNoticeById(enno);
	            List<SkillEmployNotice> skills = dao.getSkillsByEmployNoticeId(enno);
	            List<WelfareEmployNotice> welfares = dao.getWelfaresByEmployNoticeId(enno);
	            employNotice.setSkills(skills);
	            employNotice.setWelfares(welfares);
	            model.addAttribute("employNotice", employNotice);
	        }
	        return "employNoticeSave_PSH";
	    }
	    
	    
	    /*
	    @RequestMapping("/enwrite")
	    public String enWrite(EmployNotice en, @RequestParam("skname") List<String> sknames,
	    						@RequestParam("wname") List<String> wnames,
	    						@RequestParam(value = "newSknames", required = false) List<String> newSknames,
								@RequestParam(value = "newWnames", required = false) List<String> newWnames,
								HttpSession session) {
	        Company company = (Company) session.getAttribute("company");
	        String cno = company.getCno();
	        en.setCno(cno);

	        dao.enwrite(en);
		    if (sknames != null) {
		        for (String skname : sknames) {
		            SkillEmployNotice skill = new SkillEmployNotice();
		            skill.setEnno(en.getEnno());
		            skill.setSkname(skname);
		            dao.insertSkill(skill);
		        }
		    }
	        
		    if (newSknames != null) {
		        for (String skname : newSknames) {
		            SkillEmployNotice skill = new SkillEmployNotice();
		            skill.setEnno(en.getEnno());
		            skill.setSkname(skname);
		            dao.insertSkill(skill);
		        }
		    }

		    if (wnames != null) {
		        for (String wname : wnames) {
		        	WelfareEmployNotice welfare = new WelfareEmployNotice();
		        	welfare.setEnno(en.getEnno());
		        	welfare.setWname(wname);
		            dao.insertWelfare(welfare);
		        }
		    }
	        
		    if (newWnames != null) {
		        for (String wname : newWnames) {
		            WelfareEmployNotice welfare = new WelfareEmployNotice();
		            welfare.setEnno(en.getEnno());
		            welfare.setWname(wname);
		            dao.insertWelfare(welfare);
		        }
		    }


	        return "redirect:employNoticeList";
	    }
	    */
	    
	    @RequestMapping("/employNoticeCreate")
	    public String employNoticeCreate() {
	    	
	    	return "employNoticeCreate_PSH";
	    }
	    
	    @RequestMapping("/enwrite")
	    public String enWrite(EmployNotice en, @RequestParam("skname") List<String> sknames,
	    						@RequestParam("wname") List<String> wnames, HttpSession session) {
	        Company company = (Company) session.getAttribute("company");
	        String cno = company.getCno();
	        en.setCno(cno);

	        dao.enwrite(en);

	        for (String skname : sknames) {
	            SkillEmployNotice skill = new SkillEmployNotice();
	            skill.setEnno(en.getEnno());
	            skill.setSkname(skname);
	            dao.insertSkill(skill);
	        }
	        
	        for (String wname : wnames) {
	        	WelfareEmployNotice welfare = new WelfareEmployNotice();
	        	welfare.setEnno(en.getEnno());
	        	welfare.setWname(wname);
	            dao.insertWelfare(welfare);
	        }

	        return "redirect:employNoticeList";
	    }

	    @Transactional
		@RequestMapping(value = "/updateEmployNotice", method = RequestMethod.POST)
		public String updateEmployNotice(EmployNotice en,
										 @RequestParam(value = "sknames", required = false) List<String> sknames,
										 @RequestParam(value = "wnames", required = false) List<String> wnames,
										 @RequestParam(value = "newSknames", required = false) List<String> newSknames,
										 @RequestParam(value = "newWnames", required = false) List<String> newWnames) {
		    dao.updateEmployNotice(en);

		    if (sknames != null) {
		        List<SkillEmployNotice> skills = dao.getSkillsByEmployNoticeId(en.getEnno());
		        for (int i = 0; i < sknames.size(); i++) {
		        	SkillEmployNotice skill = skills.get(i);
		            skill.setSkname(sknames.get(i));
		            dao.updateSkill(skill);
		        }
		    }

		    if (newSknames != null) {
		        for (String skname : newSknames) {
		            SkillEmployNotice skill = new SkillEmployNotice();
		            skill.setEnno(en.getEnno());
		            skill.setSkname(skname);
		            dao.insertSkill(skill);
		        }
		    }

		    if (wnames != null) {
		        List<WelfareEmployNotice> welfares = dao.getWelfaresByEmployNoticeId(en.getEnno());
		        for (int i = 0; i < wnames.size(); i++) {
		            WelfareEmployNotice welfare = welfares.get(i);
		            welfare.setWname(wnames.get(i));
		            dao.updateWelfare(welfare);
		        }
		    }

		    if (newWnames != null) {
		        for (String wname : newWnames) {
		            WelfareEmployNotice welfare = new WelfareEmployNotice();
		            welfare.setEnno(en.getEnno());
		            welfare.setWname(wname);
		            dao.insertWelfare(welfare);
		        }
		    }

		    return "redirect:employNoticeList";
		}
	    
	    @Transactional
	    @RequestMapping(value = "/deleteEmployNotice", method = RequestMethod.POST)
	    public String deleteEmployNotice(@RequestParam("enno") Long enno) {
	        dao.deleteSkillsByEmployNoticeId(enno);
	        dao.deleteWelfaresByEmployNoticeId(enno);
	        dao.deleteEmployNotice(enno);
	        return "redirect:employNoticeList";
	    }
	}
