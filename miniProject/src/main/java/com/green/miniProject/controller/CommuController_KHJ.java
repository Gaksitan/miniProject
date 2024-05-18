package com.green.miniProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.miniProject.dao.ICommuDao_KHJ;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/commu")
public class CommuController_KHJ {

	@Autowired
	private ICommuDao_KHJ dao;

	@RequestMapping("/")
	public String root(Model model) {

		String id = "개인회원";

		if (id.equals("개인회원")) {

			model.addAttribute("list", dao.getAllWhenMember());

		} else if (id.equals("기업회원")) {

			model.addAttribute("list", dao.getAllWhenCompany());
		}

		return "community_KHJ";
	}

	@RequestMapping("/view")
	public String view(HttpServletRequest request, Model model) {

		String btitle = request.getParameter("btitle");
		model.addAttribute("list", dao.detailDao(btitle));
		System.out.println(model.addAttribute("list", dao.detailDao(btitle)));
		return "list";
	}

}
