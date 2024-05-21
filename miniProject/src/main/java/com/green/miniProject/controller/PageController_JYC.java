package com.green.miniProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/page")
public class PageController_JYC {

	@GetMapping("/")
	public String root() {

		
		return "";
	}
}