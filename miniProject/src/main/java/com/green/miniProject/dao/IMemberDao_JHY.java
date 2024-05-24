package com.green.miniProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.miniProject.domain.Certificate;
import com.green.miniProject.domain.CheckScrapEN;
import com.green.miniProject.domain.CheckSubscribeCom;
import com.green.miniProject.domain.Company;
import com.green.miniProject.domain.Degree;
import com.green.miniProject.domain.EmployNotice;
import com.green.miniProject.domain.Experience;
import com.green.miniProject.domain.JoinApplyResumeList;
import com.green.miniProject.domain.JoinEmployNoticeAndCompany;
import com.green.miniProject.domain.Link;
import com.green.miniProject.domain.Member;
import com.green.miniProject.domain.Resume;
import com.green.miniProject.domain.ScrapEmployNotice;
import com.green.miniProject.domain.Skill;
import com.green.miniProject.domain.SkillMatchingEN;
import com.green.miniProject.domain.SkillMatchingMR;

@Mapper
public interface IMemberDao_JHY {
	
	public void regist(@Param("member")Member member);
	public List<Resume> getResumeList(@Param("mid") String mid);
	public Member loginCheck(@Param("mid")String mid, @Param("mpw")String mpw);
	public Resume getResume(@Param("rno") Long rno);
	public Member getMember(@Param("mid") String mid);
	public void writeResume(@Param("resume") Resume resume);
	public void updateResume(@Param("resume") Resume resume);
	public List<JoinApplyResumeList> applyResumeList(@Param("mid") String mid);
	public List<CheckSubscribeCom> checkSubscribe(@Param("mid") String mid);
	public List<CheckScrapEN> checkScrap(@Param("mid") String mid);
	public void updateMember(@Param("member") Member member);
	public List<SkillMatchingEN> skillmatchingEN();  
	public List<SkillMatchingMR> skillmatchingMR(@Param("mid") String mid);
	public List<EmployNotice> employNotice();
	public void deleteMember(@Param("mid") String mid);
	public List<JoinEmployNoticeAndCompany> getEmployNotice();
	public List<Company> getCompanyList();
	
	public List<Skill> getResumeSkillList(@Param("rno") Long rno);
	public List<Degree> getResumeDegreeList(@Param("rno") Long rno);
	public List<Experience> getResumeExperienceList(@Param("rno") Long rno);
	public List<Certificate> getResumeCertificateList(@Param("rno") Long rno);
	public List<Link> getResumeLinkList(@Param("rno") Long rno);
	
	public void writeResumeSkill(@Param("rskill") Skill rskill);
	public void writeResumeExp(@Param("exp") Experience exp);
	public void writeResumeDegree(@Param("degree") Degree degree);
	public void writeResumeCertificate(@Param("certificate") Certificate cer);
	public void writeResumeLink(@Param("rlink") Link rlink);
	
	public void updateResumeSkill(@Param("rskill") Skill rskill);
	public void updateResumeExp(@Param("exp") Experience exp);
	public void updateResumeDegree(@Param("degree") Degree degree);
	public void updateResumeCertificate(@Param("certificate") Certificate cer);
	public void updateResumeLink(@Param("rlink") Link rlink);
	
	public List<ScrapEmployNotice> getScrap(@Param("mid")String mid);
}
