package com.gura.spring03.exception;

import org.springframework.dao.DataAccessException;
/*
 *   DataAccessException 추상 클래스를 상속 받은 클래스를 정의한다.
 */
public class DeleteFailException extends DataAccessException{
	//생성자를 반드시 정의 해야 한다. 
	public DeleteFailException(String msg) {
		super(msg);
		
	}

}
