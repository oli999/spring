package com.gura.spring03.shop.dao;

import com.gura.spring03.shop.dto.OrderDto;

public interface OrderDao {
	//배송 정보를 추가하는 메소드 
	public void addOrder(OrderDto dto);
}
