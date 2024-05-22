package com.green.miniProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.miniProject.domain.CompanySectorAndCompany;

@Mapper
public interface ICompanySectorDAO_JYC {

	public List<CompanySectorAndCompany> getCompanySectorAndCompanyList(@Param("scname") String scname, @Param("cno") String cno);
	public String getScname(@Param("cno") String cno);
}
