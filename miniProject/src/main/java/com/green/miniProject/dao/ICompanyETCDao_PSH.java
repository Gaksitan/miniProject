package com.green.miniProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.miniProject.domain.ApplyResume;
import com.green.miniProject.domain.Degree;
import com.green.miniProject.domain.EmployNotice;
import com.green.miniProject.domain.Experience;
import com.green.miniProject.domain.InterestMember;
import com.green.miniProject.domain.Link;
import com.green.miniProject.domain.Member;
import com.green.miniProject.domain.Resume;
import com.green.miniProject.domain.Skill;

@Mapper
public interface ICompanyETCDao_PSH {
		
	List<InterestMember> getAllInterestMembers();
	
	void removeInterest(@Param("imno") Long imno);
	//관심 구직자
	
	 List<ApplyResume> getApplyResumesByCompany(String cno);
	//지원받은 이력서 리스트
	
	 //public void updateApplicantCount(Long enno);
	 
	 InterestMember findInterestMember(@Param("cno") String cno, @Param("mid") String mid);
	 void addInterestMember(@Param("cno") String cno, @Param("mid") String mid);
	 void deleteInterestMember(@Param("cno") String cno, @Param("mid") String mid);
	 //관심버튼
	 
	List<EmployNotice> getEmployNoticesByCno(@Param("cno") String cno);
	//채용공고 리스트
	
	Member getApplicantDetailByMid(@Param("mid") String mid);

    List<Resume> getResumeListByMid(@Param("mid") String mid);
    
    Resume getResumeByRno(@Param("rno") String rno);
    
    List<Skill> getSkillListByRno(@Param("rno") String rno);
    List<Experience> getExperienceListByRno(@Param("rno") String rno);
    List<Degree> getDegreeListByRno(@Param("rno") String rno);
    List<Link> getLinkListByRno(@Param("rno") String rno);
}
