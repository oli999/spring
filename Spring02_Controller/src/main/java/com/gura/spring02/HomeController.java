package com.gura.spring02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//1. 클래스가 컨트롤러 역활을 할수 있도록 
@Controller
public class HomeController {
	
	//2. 어떤 요청을 처리할지 요청 맵핑
	@RequestMapping("/home")
	public String home() {
		//3. 비즈니스 로직 처리
		
		//4. view 페이지의 정보 리턴
		return "home";// /WEB-INF/views/home.jsp
	}
	
}








