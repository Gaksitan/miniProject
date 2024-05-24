package com.green.miniProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.miniProject.domain.Company;
import com.green.miniProject.domain.CompanyManager;
import com.green.miniProject.domain.EmployNotice;
import com.green.miniProject.domain.Member;
import com.green.miniProject.domain.Skill;
import com.green.miniProject.domain.SkillEmployNotice;
import com.green.miniProject.domain.WelfareEmployNotice;

@Mapper
public interface ICompanyDao_PSH {
	
	public void insertCompany(@Param("com") Company com);
	public void insertCompanyManager(@Param("cm") CompanyManager cm);
	// 회원가입
	
	public CompanyManager select(@Param("cmid") String cmid, @Param("cmpw") String cmpw);
	public Company getCompanyByCno(String cno);
	// 로그인
	
	public Company getCompany(@Param("cno") String cno);
	public CompanyManager getCompanyManager(@Param("cmid") String cmid);
	//중복체크
	
	public void updateComInfo(Company com);
	public void updateCMinfo(CompanyManager cm);
	public void deleteCM(CompanyManager cm);
	// 정보수정
	
	public void enwrite(EmployNotice en);
	public void insertSkill(SkillEmployNotice skill);
	public void insertWelfare(WelfareEmployNotice welfare);
	public EmployNotice getEmployNoticeById(Long enno);
	public List<SkillEmployNotice> getSkillsByEnno(Long enno);
	//채용공고 작성
	
	public void updateEmployNotice(EmployNotice en);	
	public List<SkillEmployNotice> getSkillsByEmployNoticeId(Long enno);
	public List<WelfareEmployNotice> getWelfaresByEmployNoticeId(Long enno);
	
	public void updateSkill(SkillEmployNotice skill);
	public void updateWelfare(WelfareEmployNotice welfare);
	
	public void deleteEmployNotice(Long enno);
	public void deleteSkillsByEmployNoticeId(Long enno);
	public void deleteWelfaresByEmployNoticeId(Long enno);
	
	public void deleteSkill(String enno, String skname);
	public void deleteWelfare(String enno, String welfare);
	
	public void deleteSkillBySkno(Long skno);
	
	public void deleteWelfareByWno(Long wno);
	///////////////////////
	
	List<Skill> getSknameByCno(@Param("cno") String cno);

	//스킬매칭
	
}
