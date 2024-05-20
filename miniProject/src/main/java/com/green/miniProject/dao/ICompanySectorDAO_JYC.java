package com.green.miniProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.miniProject.domain.CompanySectorAndCompany;

@Mapper
public interface ICompanySectorDAO_JYC {

	public List<CompanySectorAndCompany> getCompanySectorAndCompanyList(@Param("cno") String cno);
}
