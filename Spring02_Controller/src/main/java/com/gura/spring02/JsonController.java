package com.gura.spring02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gura.spring02.dto.MemberDto;

@Controller
public class JsonController {
	
	@RequestMapping("/json/test01")
	@ResponseBody // @ResponseBody 로 설정하고 String 을 리턴하면
	public String json01() {
		
		//리턴되는 문자열이 클라이언트에게 그대로 출력된다.
		return "{\"msg\":\"hello~\"}";
	}
	
	@RequestMapping("/json/test02")
	@ResponseBody
	public Map<String, Object> json02(){
		
		Map<String, Object> map=new HashMap<>();
		map.put("num", 1);
		map.put("name", "김구라");
		map.put("addr", "노량진");
		map.put("isMan", true);
		return map;
	}
	
	@RequestMapping("/json/test03")
	@ResponseBody
	public List<String> json03(){
		List<String> list=new ArrayList<>();
		list.add("하나");
		list.add("두울");
		list.add("세엣");
		return list;
	}
	@RequestMapping("/json/test04")
	@ResponseBody
	public List<Map<String, Object>> json04(){
		
		// Generic class 가 Map 인 List 객체 생성 
		List<Map<String, Object>> list=new ArrayList<>();
		
		Map<String, Object> map1=new HashMap<>();
		map1.put("num", 1);
		map1.put("name", "김구라");
		
		Map<String, Object> map2=new HashMap<>();
		map2.put("num", 2);
		map2.put("name", "해골");
		
		Map<String, Object> map3=new HashMap<>();
		map3.put("num", 3);
		map3.put("name", "원숭이");
		
		list.add(map1);
		list.add(map2);
		list.add(map3);
		
		return list;
	}
	
	@RequestMapping("/json/test05")
	@ResponseBody
	public MemberDto json05() {
		MemberDto dto=new MemberDto(1, "김구라", "노량진");
		return dto;
	}
	
	@RequestMapping("/json/test06")
	@ResponseBody
	public List<MemberDto> json06(){
		List<MemberDto> list=new ArrayList<>();
		list.add(new MemberDto(1, "김구라", "노량진"));
		list.add(new MemberDto(2, "해골", "행신동"));
		list.add(new MemberDto(3, "원숭이", "동물원"));
		return list;
	}
	
}















