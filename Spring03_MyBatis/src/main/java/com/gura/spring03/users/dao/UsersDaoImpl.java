package com.gura.spring03.users.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring03.users.dto.UsersDto;

@Repository
public class UsersDaoImpl implements UsersDao{
	//의존객체 DI
	@Autowired
	private SqlSession session;
	//회원정보를 추가하는 메소드 
	@Override
	public void insert(UsersDto dto) {
		session.insert("users.insert", dto);
	}
	//회원 한명의 정보를 id 로 Select 해서 리턴하는 메소드 
	@Override
	public UsersDto getData(String id) {
		UsersDto dto=session.selectOne("users.getData", id);
		return dto;
	}
	//회원 한명의 정보를 수정하는 메소드 
	@Override
	public void update(UsersDto dto) {
		session.update("users.update", dto);
	}
	//회원 한명의 정보를 삭제하는 메소드 
	@Override
	public void delete(String id) {
		session.delete("users.delete", id);
	}
	//사용할수 있는 아이디 인지 여부를 리턴하는 메소드 
	@Override
	public boolean canUseId(String id) {
		String result=session.selectOne("users.isExist", id);
		if(result==null) {// select 된 결과가 없으면 사용가능 
			return true;
		}else {
			return false;
		}
	}
	//비밀번호 수정하는 메소드 
	@Override
	public void updatePwd(UsersDto dto) {
		session.update("users.updatePwd", dto);
	}
	@Override
	public void updateProfile(UsersDto dto) {
		session.update("users.updateProfile", dto);
	}

}











