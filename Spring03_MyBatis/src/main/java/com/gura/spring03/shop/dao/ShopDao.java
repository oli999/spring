package com.gura.spring03.shop.dao;

import java.util.List;

import com.gura.spring03.shop.dto.ShopDto;

public interface ShopDao {
	public List<ShopDto> getList(); //상품 목록을 리턴해주는 메소드
	public void minusCount(int num); //상품 재고를 감소 시키는 메소드
	public void minusMoney(ShopDto dto); //잔고 감소
	public void plusPoint(ShopDto dto); //포인트 증가
	public int getPrice(int num); //상품의 가격을 리턴해주는 메소드 
}
