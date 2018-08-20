package com.gura.spring03.shop.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring03.exception.NodeliveryException;
import com.gura.spring03.shop.dto.OrderDto;

@Repository
public class OrderDaoImpl implements OrderDao{
	@Autowired
	private SqlSession session;
	
	@Override
	public void addOrder(OrderDto dto) {
		
		//인자로 전달되는 주문정보(배송정보) 를 저장하기 
		session.insert("shop.addOrder", dto);
		
		//특정 조건에서 예외를 발생 시켜야 하는 경우
		//DataAccessException 클래스를 상속받은 예외를 발생 시킨다.
		//NodeliveryException ne=
		//		new NodeliveryException("해당 지역은 배송 불가 지역");
		//throw ne;
	}

}















