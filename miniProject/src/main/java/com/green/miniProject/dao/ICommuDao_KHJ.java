package com.green.miniProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.green.miniProject.domain.Board;
import com.green.miniProject.domain.Notice;

@Mapper
public interface ICommuDao_KHJ {
	
	public List<Board> getAllWhenMember();
	public List<Board> getAllWhenCompany();
	public List<Object> detailDao(long bno);
	
	//공지사항 관련 메서드
	public List<Notice> getNoticeList(); 
	public Notice getNoticeDetail(String nno);
}
