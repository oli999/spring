package com.gura.spring02;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
	@RequestMapping("/fortune")
	public String showFortune(HttpServletRequest request) {
		// view 페이지에 전달할 Model 
		String fortuneToday="동쪽으로 가면 귀인을 만나요";
		// request 에 담기
		request.setAttribute("fortuneToday", fortuneToday);
		// view 페이지로 forward 이동 
		return "fortune";
	}
	
	@RequestMapping("/person")
	public ModelAndView showPerson() {
		String personToday="송예성";
		// request 에 담을 Model 과 view 페이지 정보를 가지는 객체 
		ModelAndView mView=new ModelAndView();
		mView.addObject("personToday", personToday);
		mView.setViewName("person");
		
		return mView;
	}
}












