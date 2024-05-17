package com.green.miniProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/commu")
public class CommuController_KHJ {
	
	@RequestMapping("/")
	public String root() {
		
		
		return "community_KHJ";
	}

	
	
}
