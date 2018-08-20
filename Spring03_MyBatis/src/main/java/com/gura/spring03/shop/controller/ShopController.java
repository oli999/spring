package com.gura.spring03.shop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring03.shop.service.ShopService;

@Controller
public class ShopController {
	@Autowired
	private ShopService shopService;
	
	//상품 목록 보기 요청 처리
	@RequestMapping("/shop/list")
	public ModelAndView list(ModelAndView mView) {
		
		shopService.getList(mView);
		
		mView.setViewName("shop/list");
		return mView;
	}
	//상품 구매하기 요청 처리
	@RequestMapping("/shop/buy")
	public ModelAndView authBuy(HttpServletRequest request,
			ModelAndView mView) {
		shopService.buy(request, mView);
		mView.setViewName("shop/buy");
		return mView;
	}
}























