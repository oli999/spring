package com.gura.spring03.member.service;

import org.springframework.web.servlet.ModelAndView;

import com.gura.spring03.member.dto.MemberDto;

public interface MemberService {
	public void list(ModelAndView mView);
	public void insert(MemberDto dto);
	public void update(MemberDto dto);
	public void delete(int num);
	public void getData(ModelAndView mView, int num);
}
