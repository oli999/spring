package com.gura.spring03;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	//로그를 찍기위한 도구 
	private static final Logger logger = 
			LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/home")
	public String home(Locale locale, Model model) {
		logger.info("/home.do 요청 처리!");
		return "home";
	}
	
}
