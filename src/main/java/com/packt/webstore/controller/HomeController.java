package com.packt.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String welcome(Model model) {
		model.addAttribute("greeting", "Welcome to Web Store!");
		model.addAttribute("tagline", "The one and only amazing webstore");

		return "forward:/welcome/greeting";
		
		// REDIRECT vs FORWARD
		//If we use forward prefix, the process will happen in the server side so
		//in this way we can refer to greeting and tagline attributes.
		//However if we use redirect prefix, this cause another request (and we haven't
		//sent any arguments in the second request) and this cause we
		//can't refer to these attributes because they don't exist.

	}

	@RequestMapping("/welcome/greeting")
	public String greeting() {
		return "welcome";
	}
}