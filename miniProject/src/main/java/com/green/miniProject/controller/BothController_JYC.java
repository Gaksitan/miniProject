package com.green.miniProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/both")
public class BothController_JYC {

	@RequestMapping("/a")
	public String header() {
		return "header_JYC";
	}
	
	@RequestMapping("/b")
	public String footer() {
		return "footer_JYC";
	}
	
	@RequestMapping("/c")
	public String serviceMain() {
		return "serviceMainBoth_JYC";
	}
}
