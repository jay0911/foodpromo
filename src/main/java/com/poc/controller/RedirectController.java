package com.poc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {
	@GetMapping("/homepagepublic")
	public String goToPage() {
		return "pages/homepagepublic";
	}
}
