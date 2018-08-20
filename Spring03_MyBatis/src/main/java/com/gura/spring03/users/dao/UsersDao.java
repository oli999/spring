package com.gura.spring03.users.dao;

import com.gura.spring03.users.dto.UsersDto;

public interface UsersDao {
	public void insert(UsersDto dto);
	public UsersDto getData(String id);
	public void update(UsersDto dto);
	public void delete(String id);
	public boolean canUseId(String id);
	public void updatePwd(UsersDto dto);
}
