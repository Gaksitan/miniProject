package com.green.miniProject.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.miniProject.domain.Company;
import com.green.miniProject.domain.CompanyManager;
import com.green.miniProject.domain.EmployNotice;

@Mapper
public interface ICompanyDao_PSH {
	
	public void insertCompany(@Param("com") Company com);
	public void insertCompanyManager(@Param("cm") CompanyManager cm);
	// 회원가입
	
	public CompanyManager select(@Param("cmid") String cmid, @Param("cmpw") String cmpw);
	// 로그인
	
	public void updateComInfo(Company com);
	public void updateCMInfo(CompanyManager cm);
	// 정보수정
	
	public void enwrite(@Param("em") EmployNotice em);
	// 채용공고 작성
}
