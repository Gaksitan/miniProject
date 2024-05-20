package com.green.miniProject.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.miniProject.domain.Company;
import com.green.miniProject.domain.CompanyManager;
import com.green.miniProject.domain.DegreeEmployNotice;
import com.green.miniProject.domain.EmployNotice;
import com.green.miniProject.domain.ExperienceEmployNotice;
import com.green.miniProject.domain.SkillEmployNotice;

@Mapper
public interface ICompanyDao_PSH {
	
	public void insertCompany(@Param("com") Company com);
	public void insertCompanyManager(@Param("cm") CompanyManager cm);
	// 회원가입
	
	public CompanyManager select(@Param("cmid") String cmid, @Param("cmpw") String cmpw);
	public Company getCompanyByCno(String cno);
	// 로그인
	
	public void updateComInfo(Company com);
	public void updateCMinfo(CompanyManager cm);
	// 정보수정
	
	public void enwrite(EmployNotice en);
	public void insertExperience(ExperienceEmployNotice experience);
	public void insertDegree(DegreeEmployNotice degree);
	public void insertSkill(SkillEmployNotice skill);
	//채용공고 작성


}
