package com.green.miniProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.miniProject.domain.EmployNotice;

@Mapper
public interface IEmployNoticeDAO_JYC {

	public List<EmployNotice> searchEmployNoticeList(@Param("keyword") String keyword);
	public List<EmployNotice> getEmployNoticeList(@Param("cno") String cno);
	public EmployNotice getEmployNotice(@Param("cno") String cno, @Param("enno") Long enno);
}
