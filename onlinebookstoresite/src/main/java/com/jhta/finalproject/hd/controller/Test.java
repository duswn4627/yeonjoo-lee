package com.jhta.finalproject.hd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test {
	@RequestMapping("/main")
	public String home() {
		return ".main";
	}
}
