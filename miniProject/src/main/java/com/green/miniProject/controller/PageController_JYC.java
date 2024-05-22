package com.green.miniProject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.miniProject.dao.ICompanyDAO_JYC;
import com.green.miniProject.dao.ICompanySectorDAO_JYC;
import com.green.miniProject.dao.IEmployNoticeDAO_JYC;
import com.green.miniProject.dao.IMemberDAO_JYC;
import com.green.miniProject.dao.IScoreMemComDAO_JYC;
import com.green.miniProject.domain.Company;
import com.green.miniProject.domain.CompanySectorAndCompany;
import com.green.miniProject.domain.EmployNotice;
import com.green.miniProject.domain.Member;
import com.green.miniProject.domain.ScoreMemCom;
import com.green.miniProject.repository.EmployNoticeRepository;
import com.green.miniProject.service.EmployNoticeService_jyc;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/page")
public class PageController_JYC {

	@Autowired
	private ICompanyDAO_JYC comdao;
	
	@Autowired
	private IMemberDAO_JYC memdao;
	
	@Autowired
	private IEmployNoticeDAO_JYC endao;
	
	@Autowired
	private EmployNoticeService_jyc employNoticeService;
	
	@Autowired
	private IScoreMemComDAO_JYC smcdao;
	
	@Autowired
	private ICompanySectorDAO_JYC companySectorDao;
	
	
	@GetMapping("/company")
	public String company(@RequestParam("page") Long page, @RequestParam("keyword") String keyword, Model model, @RequestParam("encurrentpage") Long encurrentpage, @RequestParam("memcurrentpage") Long memcurrentpage) {
		
		List<Company> comlist = comdao.getCompanyList(keyword, ((page - 1) * 10));
		model.addAttribute("comlist", comlist);
		model.addAttribute("comcount", comdao.getCount(keyword));
		
		double comcount = comdao.getCount(keyword);
		double compage = Math.ceil(comcount / 10.0);
		model.addAttribute("compage", compage);
		
		List<EmployNotice> enlist = endao.searchEmployNoticeList(keyword, ((encurrentpage - 1) * 10));
		model.addAttribute("enlist", enlist);
		model.addAttribute("encount", endao.getCount(keyword));
		
		double encount = endao.getCount(keyword);
		double enpage = Math.ceil(encount / 10.0);
		
		model.addAttribute("enpage", enpage);
		model.addAttribute("keyword", keyword);
		
		List<Member> memlist = memdao.getMemberList(keyword, ((memcurrentpage - 1) * 10));
		model.addAttribute("memlist", memlist);
		model.addAttribute("memcount", memdao.getCount(keyword));
		
		double memcount = memdao.getCount(keyword);
		double mempage = Math.ceil(memcount / 10.0);
		
		model.addAttribute("memcurrentpage", memcurrentpage);
		model.addAttribute("comcurrentpage", page);
		model.addAttribute("encurrentpage", encurrentpage);
		
		model.addAttribute("mempage", mempage);
		
		return "searchResult_JYC";
	}
	
	@GetMapping("/member")
	public String member(@RequestParam("page") Long page, @RequestParam("keyword") String keyword, Model model, @RequestParam("comcurrentpage") Long comcurrentpage, @RequestParam("encurrentpage") Long encurrentpage) {
		
		List<Company> comlist = comdao.getCompanyList(keyword, ((comcurrentpage - 1) * 10));
		model.addAttribute("comlist", comlist);
		model.addAttribute("comcount", comdao.getCount(keyword));
		
		double comcount = comdao.getCount(keyword);
		double compage = Math.ceil(comcount / 10.0);
		model.addAttribute("compage", compage);
		
		List<EmployNotice> enlist = endao.searchEmployNoticeList(keyword, ((encurrentpage - 1) * 10));
		model.addAttribute("enlist", enlist);
		model.addAttribute("encount", endao.getCount(keyword));
		
		double encount = endao.getCount(keyword);
		double enpage = Math.ceil(encount / 10.0);
		
		model.addAttribute("enpage", enpage);
		model.addAttribute("keyword", keyword);
		
		List<Member> memlist = memdao.getMemberList(keyword, ((page - 1) * 10));
		model.addAttribute("memlist", memlist);
		model.addAttribute("memcount", memdao.getCount(keyword));
		
		double memcount = memdao.getCount(keyword);
		double mempage = Math.ceil(memcount / 10.0);
		
		model.addAttribute("memcurrentpage", page);
		model.addAttribute("comcurrentpage", comcurrentpage);
		model.addAttribute("encurrentpage", encurrentpage);
		
		model.addAttribute("mempage", mempage);
		
		return "searchResult_JYC";
	}
	
	@GetMapping("/employnotice")
	public String employnotice(@RequestParam("page") Long page, @RequestParam("keyword") String keyword, Model model, @RequestParam("memcurrentpage") Long memcurrentpage, @RequestParam("comcurrentpage") Long comcurrentpage) {
		
		List<Company> comlist = comdao.getCompanyList(keyword, ((comcurrentpage - 1) * 10));
		model.addAttribute("comlist", comlist);
		model.addAttribute("comcount", comdao.getCount(keyword));
		
		double comcount = comdao.getCount(keyword);
		double compage = Math.ceil(comcount / 10.0);
		model.addAttribute("compage", compage);
		
		Long enpage2 = (page - 1L) * 10L;
		
		List<EmployNotice> enlist = endao.searchEmployNoticeList(keyword, ((page - 1) * 10));
		model.addAttribute("enlist", enlist);
		model.addAttribute("encount", endao.getCount(keyword));
		
		double encount = endao.getCount(keyword);
		double enpage = Math.ceil(encount / 10.0);
		
		model.addAttribute("enpage", enpage);
		model.addAttribute("keyword", keyword);
		
		List<Member> memlist = memdao.getMemberList(keyword, ((memcurrentpage - 1) * 10));
		model.addAttribute("memlist", memlist);
		model.addAttribute("memcount", memdao.getCount(keyword));
		
		double memcount = memdao.getCount(keyword);
		double mempage = Math.ceil(memcount / 10.0);
		
		model.addAttribute("memcurrentpage", memcurrentpage);
		model.addAttribute("comcurrentpage", comcurrentpage);
		model.addAttribute("encurrentpage", page);
		
		model.addAttribute("mempage", mempage);
		
		
		return "searchResult_JYC";
	}
	
	@RequestMapping("/companyEmployNotice")
    public String list(Model model, @RequestParam(value="page", defaultValue="1") int page, @RequestParam("cno") String cno) {
        Page<com.green.miniProject.entity.EmployNotice> paging = employNoticeService.getList(page);
        model.addAttribute("enlist", paging.getContent());
        model.addAttribute("totalPages", paging.getTotalPages());
        model.addAttribute("hasNext", paging.hasNext());
        model.addAttribute("hasPrevious", paging.hasPrevious());
        
        model.addAttribute("currentPage", paging.getNumber() + 1);
        
        Company company = comdao.getCompany(cno);
		List<ScoreMemCom> smclist = smcdao.getScoreMemComList(cno);

		model.addAttribute("company", company);
		if (!smclist.isEmpty()) {
			model.addAttribute("smclist", smclist);
		}
		

		int comCount = comdao.count();
		List<Company> comList = new ArrayList<>();

		String scname = companySectorDao.getScname(cno);
		List<CompanySectorAndCompany> companySectorAndCompanyList = companySectorDao
				.getCompanySectorAndCompanyList(scname, cno);
		if(companySectorAndCompanyList.size() > 0) {
			model.addAttribute("recommendList", companySectorAndCompanyList);
		}
        
        
        return "companyDetail_JYC";
}
	
}
