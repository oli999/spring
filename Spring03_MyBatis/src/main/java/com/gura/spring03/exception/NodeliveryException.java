package com.gura.spring03.exception;

import org.springframework.dao.DataAccessException;
/*
 *  배송이 불가능한 상황에서 발생시킬 Exception 
 */
public class NodeliveryException extends DataAccessException{

	public NodeliveryException(String msg) {
		super(msg);
		
	}

}










