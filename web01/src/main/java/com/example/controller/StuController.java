package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //html을 리턴
@RequestMapping("/stu")
public class StuController {
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("pageName", "stu/list");
		return "home";
	}
	
	@GetMapping("/read")
	public String read(Model model) {
		model.addAttribute("pageName", "stu/read");
		return "home";
	}
}
