package com.green.miniProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.miniProject.domain.Board;
import com.green.miniProject.domain.BoardTag;

@Mapper
public interface ICommuDao_KHJ {
	
	public List<Board> getAllWhenMember();
	public List<Board> getAllWhenCompany();
	public List<BoardTag>detailDao(@Param("bno") long bno);
	public int insertContentWhenMem(@Param("mid") String mid, @Param("title") String title, @Param("content") String content);
	public Long getBno(@Param("title") String title, @Param("content") String content);
	public int insertTagWhenMem(@Param("mid") String mid, @Param("tag") String tag, @Param("bno")Long bno);
	public Board myList();
}
