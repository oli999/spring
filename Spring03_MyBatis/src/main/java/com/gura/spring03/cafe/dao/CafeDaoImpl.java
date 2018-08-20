package com.gura.spring03.cafe.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring03.cafe.dto.CafeDto;

@Repository
public class CafeDaoImpl implements CafeDao{
	
	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(CafeDto dto) {
		/*
		 *  Mapper namespace : cafe
		 *  sql id : insert
		 *  parameterType : cafeDto(type alias) 
		 */
		session.insert("cafe.insert", dto);
	}

	@Override
	public int getCount(CafeDto dto) {
		/*
		 *  Mapper namespace : cafe
		 *  sql id : getCount
		 *  parameterType : cafeDto
		 *  resultType : int
		 */
		int count=session.selectOne("cafe.getCount", dto);
		
		return count;
	}

	@Override
	public List<CafeDto> getList(CafeDto dto) {
		/*
		 *  resultType : cafeDto 
		 */
		List<CafeDto> list=session.selectList("cafe.getList", dto);
		return list;
	}

	@Override
	public CafeDto getData(CafeDto dto) {
		// resultType : cafeDto 
		CafeDto resultDto=session.selectOne("cafe.getData", dto);
		return resultDto;
	}

	@Override
	public void delete(int num) {
		session.delete("cafe.delete", num);
	}

	@Override
	public void update(CafeDto dto) {
		session.update("cafe.update", dto);
	}

	@Override
	public void addViewCount(int num) {
		session.update("cafe.addViewCount", num);
	}

}





