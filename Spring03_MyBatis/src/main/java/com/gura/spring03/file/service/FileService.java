package com.gura.spring03.file.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.gura.spring03.file.dto.FileDto;

public interface FileService {
	public void getList(ModelAndView mView, int pageNum);
	public void insert(HttpServletRequest request, FileDto dto);
	public void getData(ModelAndView mView, int num);
	public void delete(HttpServletRequest request, int num);
}












