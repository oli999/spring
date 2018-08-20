package com.gura.spring03.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring03.member.dao.MemberDao;
import com.gura.spring03.member.dto.MemberDto;
/*
 *  회원 정보에 관련된 비즈니스 로직을 수행하는 서비스 
 */
@Service
public class MemberServiceImpl implements MemberService{
	//의존 객체 주입
	@Autowired
	private MemberDao dao;
	
	@Override
	public void list(ModelAndView mView) {
		//Dao 객체를 이용해서 회원 목록을 얻어오고 
		List<MemberDto> list=dao.getList();
		//인자로 전달된 ModelAndView 객체에 담는다.
		mView.addObject("list", list);
	}

	@Override
	public void insert(MemberDto dto) {
		//MemberDao 객체를 이용해서 회원 정보를 DB 에 저장하기 
		dao.insert(dto);
	}
	@Override
	public void update(MemberDto dto) {
		dao.update(dto);
	}
	@Override
	public void delete(int num) {
		dao.delete(num);
	}
	@Override
	public void getData(ModelAndView mView, int num) {
		MemberDto dto=dao.getData(num);
		mView.addObject("dto", dto);
	}

}









