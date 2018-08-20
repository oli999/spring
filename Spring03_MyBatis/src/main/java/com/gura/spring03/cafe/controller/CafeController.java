package com.gura.spring03.cafe.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring03.cafe.dto.CafeCommentDto;
import com.gura.spring03.cafe.service.CafeService;

@Controller
public class CafeController {
	@Autowired
	private CafeService cafeService;
	
	//글 수정 요청 처리
	@RequestMapping("/cafe/update")
	public ModelAndView authUpdate(HttpServletRequest request) {
		cafeService.update(request);
		return new ModelAndView("cafe/update");
	}
	
	
	//글 수정 폼 요청처리
	@RequestMapping("/cafe/updateform")
	public ModelAndView authUpdateForm(HttpServletRequest request){
		// request 에 글 하나의 정보가 담기게 한다. 
		cafeService.detail(request);
		
		return new ModelAndView("cafe/updateform");
	}
	
	
	//글 삭제 요청 처리
	@RequestMapping("/cafe/delete")
	public ModelAndView authDelete(HttpServletRequest request) {
		
		cafeService.delete(request);
		
		return new ModelAndView("redirect:/cafe/list.do");
	}
	
	//새 댓글 저장 요청처리
	@RequestMapping("/cafe/comment_insert")
	public ModelAndView authCommentInsert
		(HttpServletRequest request , @ModelAttribute CafeCommentDto dto) {
		
		cafeService.commentInsert(dto);;
		
		return new ModelAndView
			("redirect:/cafe/detail.do?num="+dto.getRef_group());
	}
	
	//글 자세히 보기 요청 처리
	@RequestMapping("/cafe/detail")
	public ModelAndView detail(HttpServletRequest request) {
		//서비스 객체를 이용해서 글 자세히 보기에 관련된
		//Model 이 request 에 담기게 하고 
		cafeService.detail(request);
		//view 페이지로 forward 이동해서 응답하기 
		return new ModelAndView("cafe/detail");
	}
	
	
	//새글 저장 요청 처리
	@RequestMapping("/cafe/insert")
	public ModelAndView authInsert(HttpServletRequest request) {
		//서비스 객체를 이용해서 새글을 저장하고
		cafeService.insert(request);
		//view 페이지로 forward 이동
		return new ModelAndView("cafe/insert");
	}
	
	
	//새글 작성 폼 요청 처리
	@RequestMapping("/cafe/insertform")
	public ModelAndView authInsertform(HttpServletRequest request) {
		
		return new ModelAndView("cafe/insertform");
	}
	
	//카페 글 목록 보기 요청 처리 
	@RequestMapping("/cafe/list")
	public ModelAndView list(HttpServletRequest request) {
		//인자로 전달받은 HttpServletRequest 객체를 서비스에 전달해서
		//비즈니스 로직을 수행하고 
		//view 페이지에서 필요한 데이터가 request 영역에 담기게 한다.
		cafeService.getList(request);
		//view 페이지로 forward 이동
		return new ModelAndView("cafe/list");
	}
}
















