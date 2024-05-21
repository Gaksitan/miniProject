package com.green.miniProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.miniProject.domain.ApplyResume;
import com.green.miniProject.domain.EmployNotice;
import com.green.miniProject.domain.InterestMember;

@Mapper
public interface ICompanyETCDao_PSH {
		
	List<InterestMember> getAllInterestMembers();
	
	void removeInterest(@Param("imno") Long imno);
	//관심 구직자
	
	List<ApplyResume> getApplyResumesByCompany(@Param("cno") String cno);
	//지원받은 이력서 리스트
	
	List<EmployNotice> getEmployNoticesByCno(@Param("cno") String cno);
	//채용공고 리스트
}
