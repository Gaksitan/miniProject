package com.green.miniProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.green.miniProject.domain.Board;

@Mapper
public interface ICommuDao_KHJ {
	
	public List<Board> getAllWhenMember();
	public Board detailDao(String btitle);
	
}