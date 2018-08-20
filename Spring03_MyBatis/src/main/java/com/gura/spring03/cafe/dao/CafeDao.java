package com.gura.spring03.cafe.dao;

import java.util.List;

import com.gura.spring03.cafe.dto.CafeDto;

public interface CafeDao {
	//새글 저장하는 메소드 
	public void insert(CafeDto dto);
	//인자로 전달되는 정보에 맞는 글의 갯수를 리턴하는 메소드 
	public int getCount(CafeDto dto);
	//인자로 전달되는 정보에 맞는 글 목록을 리턴하는 메소드 
	public List<CafeDto> getList(CafeDto dto);
	//인자로 전달되는 정보에 맞는 글 하나의 정보를 리턴하는 메소드
	public CafeDto getData(CafeDto dto);
	//인자로 전달되는 글번호에 해당되는 글을 삭제하는 메소드 
	public void delete(int num);
	//인자로 전달되는 정보에 맞게 글을 수정하는 메소드
	public void update(CafeDto dto);
	//인자로 전달되는 글번호에 해당되는 글의 조회수를 증가 시키는 메소드
	public void addViewCount(int num);
	
}










