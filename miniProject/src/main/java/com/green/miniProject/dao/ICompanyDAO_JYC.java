package com.green.miniProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.miniProject.domain.Company;

@Mapper
public interface ICompanyDAO_JYC {
	public List<Company> getCompanyList(@Param("keyword") String keyword, @Param("page") Long page);
	public Company getCompany(@Param("cno") String cno);
	public int count();
	public int getCount(@Param("keyword") String keyword);
	public String getCname(@Param("cno") String cno);
}
