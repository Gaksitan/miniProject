package com.green.miniProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.miniProject.domain.Admin;

@Mapper
public interface IAdminDao_MSI {
	public List<Admin> adminDao(String aid);
	
	public int writeNotice(String ano, String ntitle, String ncontent, String nregdate);
}
