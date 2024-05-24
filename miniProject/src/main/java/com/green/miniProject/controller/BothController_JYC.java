package com.green.miniProject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.miniProject.dao.ICompanyDAO_JYC;
import com.green.miniProject.dao.IEmployNoticeDAO_JYC;
import com.green.miniProject.dao.IMemberDAO_JYC;
import com.green.miniProject.dao.IQuestionCategoryDAO_JYC;
import com.green.miniProject.domain.Company;
import com.green.miniProject.domain.EmployNotice;
import com.green.miniProject.domain.Member;
import com.green.miniProject.domain.QuestionCategory;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/both")
@Log4j2
public class BothController_JYC {

	private int startBlock = 1;
	private int startPage = 1;

	@Autowired
	private IEmployNoticeDAO_JYC endao;

	@Autowired
	private ICompanyDAO_JYC comdao;

	@Autowired
	private IMemberDAO_JYC memdao;

	@Autowired
	private IQuestionCategoryDAO_JYC qcdao;

	@RequestMapping("/header")
	public String header(HttpServletRequest request) {

		return "header_JYC";
	}

	@RequestMapping("/footer")
	public String footer() {
		return "footer_JYC";
	}

	@GetMapping("/searchResultNoMem")
	public String searchResultMem(@RequestParam("search") String search, Model model) {

		List<Company> comlist = comdao.getCompanyList(search, 0L);
		String str;
		if (comlist.size() > 0) {
			model.addAttribute("comlist", comlist);
			model.addAttribute("comcount", comdao.getCount(search));
		}

		double comcount = comdao.getCount(search);
		double compage = Math.ceil(comcount / 10.0);
		model.addAttribute("compage", compage);

		List<EmployNotice> enlist = endao.searchEmployNoticeList(search, 0L);

		if (enlist.size() > 0) {

			for (int i = 0; i < enlist.size(); i++) {
				if (enlist.get(i).getEntitle().length() > 20) {
					str = enlist.get(i).getEntitle().substring(0, 20);
					enlist.get(i).setEntitle(str + "...");
				}

			}

			model.addAttribute("enlist", enlist);
			model.addAttribute("encount", endao.getCount(search));
		}

		double encount = endao.getCount(search);
		double enpage = Math.ceil(encount / 10.0);

		model.addAttribute("enpage", enpage);
		model.addAttribute("keyword", search);

		List<Member> memlist = memdao.getMemberList(search, 0L);

		if (memlist.size() > 0) {
			model.addAttribute("memlist", memlist);
			model.addAttribute("memcount", memdao.getCount(search));
		}

		double memcount = memdao.getCount(search);
		double mempage = Math.ceil(memcount / 10.0);

		model.addAttribute("mempage", mempage);

		model.addAttribute("memcurrentpage", 1);
		model.addAttribute("comcurrentpage", 1);
		model.addAttribute("encurrentpage", 1);

		return "searchResult_JYC";
	}

	@GetMapping("/searchResultMem")
	public String searchResultMem(Model model, @RequestParam("search") String search) {

		List<Company> comlist = comdao.getCompanyList(search, 0L);
		String str;
		if (comlist.size() > 0) {
			model.addAttribute("comlist", comlist);
			model.addAttribute("comcount", comdao.getCount(search));
		}

		double comcount = comdao.getCount(search);
		double compage = Math.ceil(comcount / 10.0);
		model.addAttribute("compage", compage);

		List<EmployNotice> enlist = endao.searchEmployNoticeList(search, 0L);

		if (enlist.size() > 0) {

			for (int i = 0; i < enlist.size(); i++) {
				if (enlist.get(i).getEntitle().length() > 20) {
					str = enlist.get(i).getEntitle().substring(0, 20);
					enlist.get(i).setEntitle(str + "...");
				}

			}

			model.addAttribute("enlist", enlist);
			model.addAttribute("encount", endao.getCount(search));
		}

		double encount = endao.getCount(search);
		double enpage = Math.ceil(encount / 10.0);

		model.addAttribute("enpage", enpage);
		model.addAttribute("keyword", search);

		List<Member> memlist = memdao.getMemberList(search, 0L);

		if (memlist.size() > 0) {
			model.addAttribute("memlist", memlist);
			model.addAttribute("memcount", memdao.getCount(search));
		}

		model.addAttribute("memcurrentpage", 1);
		model.addAttribute("comcurrentpage", 1);
		model.addAttribute("encurrentpage", 1);

		double memcount = memdao.getCount(search);
		double mempage = Math.ceil(memcount / 10.0);

		model.addAttribute("mempage", mempage);

		return "searchResult_JYC";
	}

	@GetMapping("/searchResultCom")
	public String searchResultCom(@RequestParam("search") String search, Model model) {

		List<Company> comlist = comdao.getCompanyList(search, 0L);
		String str;

		if (comlist.size() > 0) {
			model.addAttribute("comlist", comlist);
			model.addAttribute("comcount", comdao.getCount(search));
		}

		double comcount = comdao.getCount(search);
		double compage = Math.ceil(comcount / 10.0);
		model.addAttribute("compage", compage);

		List<EmployNotice> enlist = endao.searchEmployNoticeList(search, 0L);

		if (enlist.size() > 0) {

			for (int i = 0; i < enlist.size(); i++) {
				if (enlist.get(i).getEntitle().length() > 20) {
					str = enlist.get(i).getEntitle().substring(0, 20);
					enlist.get(i).setEntitle(str + "...");
				}

			}

			model.addAttribute("enlist", enlist);
			model.addAttribute("encount", endao.getCount(search));
		}

		double encount = endao.getCount(search);
		double enpage = Math.ceil(encount / 10.0);

		model.addAttribute("enpage", enpage);
		model.addAttribute("keyword", search);

		List<Member> memlist = memdao.getMemberList(search, 0L);

		if (memlist.size() > 0) {
			model.addAttribute("memlist", memlist);
			model.addAttribute("memcount", memdao.getCount(search));
		}

		model.addAttribute("memcurrentpage", 1);
		model.addAttribute("comcurrentpage", 1);
		model.addAttribute("encurrentpage", 1);

		double memcount = memdao.getCount(search);
		double mempage = Math.ceil(memcount / 10.0);

		model.addAttribute("mempage", mempage);

		return "searchResult_JYC";
	}

	@GetMapping("/registQuestionForm")
	public String registQuestionForm(Model model) {

		log.info("categoryList : " + qcdao.getAllQuestionCategoryList());
		model.addAttribute("categoryList", qcdao.getAllQuestionCategoryList());

		return "registQuestionForm_JYC";
	}

}
