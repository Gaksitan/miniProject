package com.green.miniProject.dao;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.miniProject.domain.Admin;
import com.green.miniProject.domain.Notice;

@Mapper
public interface IAdminDao_MSI {
	public List<Admin> adminDao(String aid);
	
	public int writeNotice(String ano, String ntitle, String ncontent, String nregdate);

	public int updateNotice(@Param("notice") Notice notice);
	
	public int deleteNotice(@Param("nno") String nno);

}
