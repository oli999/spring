package com.gura.spring03.cafe.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.gura.spring03.cafe.dto.CafeCommentDto;

public interface CafeService {
	public void getList(HttpServletRequest request);
	public void insert(HttpServletRequest request);
	public void detail(HttpServletRequest request);
	public void commentInsert(CafeCommentDto dto);
	public void delete(HttpServletRequest request);
	public void update(HttpServletRequest request);
}













