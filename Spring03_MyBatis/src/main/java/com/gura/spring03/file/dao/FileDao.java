package com.gura.spring03.file.dao;

import java.util.List;

import com.gura.spring03.file.dto.FileDto;

public interface FileDao {
	public void delete(int num);
	public void addDownCount(int num);
	public FileDto getData(int num);
	public void insert(FileDto dto);
	public List<FileDto> getList(FileDto dto);
	public int getCount();
}
