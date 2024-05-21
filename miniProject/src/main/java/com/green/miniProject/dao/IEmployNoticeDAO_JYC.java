package com.green.miniProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.miniProject.domain.EmployNotice;
import com.green.miniProject.domain.EmployNoticeDetail;

@Mapper
public interface IEmployNoticeDAO_JYC {

	public List<EmployNotice> getAllEmployNoticeList();
	public List<EmployNotice> searchEmployNoticeList(@Param("keyword") String keyword, @Param("page") Long page);
	public List<EmployNotice> getEmployNoticeList(@Param("cno") String cno);
	public EmployNoticeDetail getEmployNotice(@Param("enno") Long enno);
	public int getCount(@Param("keyword") String keyword);
}
