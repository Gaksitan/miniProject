package com.green.miniProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.green.miniProject.domain.Board;

@Mapper
public interface ICommuDao_KHJ {
	
	public List<Board> getAllWhenMember();
	public List<Board> getAllWhenCompany();
	public List<Object> detailDao(long bno);
	
}
