package com.gura.spring03.cafe.dao;

import java.util.List;

import com.gura.spring03.cafe.dto.CafeCommentDto;

public interface CafeCommentDao {
	//새로운 댓글의 글번호를 리턴해주는 메소드 
	public int getSequence();
	//새로운 댓글을 저장하는 메소드 
	public void insert(CafeCommentDto dto);
	//인자로 전달되는 그룹에 해당하는 댓글 목록을 리턴하는 메소드 
	public List<CafeCommentDto> getList(int ref_group);
}












