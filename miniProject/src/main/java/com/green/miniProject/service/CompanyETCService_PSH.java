package com.green.miniProject.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.miniProject.dao.ICompanyETCDao_PSH;
import com.green.miniProject.domain.ApplyResume;
import com.green.miniProject.domain.Degree;
import com.green.miniProject.domain.EmployNotice;
import com.green.miniProject.domain.Experience;
import com.green.miniProject.domain.InterestMember;
import com.green.miniProject.domain.Link;
import com.green.miniProject.domain.Member;
import com.green.miniProject.domain.Resume;
import com.green.miniProject.domain.ScoreComMem;
import com.green.miniProject.domain.Skill;

@Service
public class CompanyETCService_PSH {
	
	@Autowired
	private ICompanyETCDao_PSH dao;
	
	public List<InterestMember> getAllInterestMembers(){
		return dao.getAllInterestMembers();
	}
	
    public void removeInterest(Long imno) {
        dao.removeInterest(imno);
    }
    
    //관심 구직자
    
    public List<ApplyResume> getApplyResumesByCompany(String cno) {
        return dao.getApplyResumesByCompany(cno);
    }
    
    public int getApplyCountByEnno(Long enno) {
        Integer count = dao.getApplyCountByEnno(enno);
        return count != null ? count : 0; // null 체크
    }
    
    //지원받은 이력서 리스트
    
    
    public List<EmployNotice> getEmployNoticesByCno(String cno) {
        return dao.getEmployNoticesByCno(cno);
    }
    // 채용공고 리스트
    
    public boolean toggleInterest(String cno, String mid) {
        InterestMember existing = dao.findInterestMember(cno, mid);
        if (existing == null) {
            dao.addInterestMember(cno, mid);
            return true;
        } else {
            dao.deleteInterestMember(cno, mid);
            return false;
        }
    }
    //구독
    
    public int calculateAge(LocalDate birthDate) {
        LocalDate today = LocalDate.now();
        return Period.between(birthDate, today).getYears();
    }
    
    public Member getApplicantDetailByMid(String mid) {
        return dao.getApplicantDetailByMid(mid);
    }

    public List<Resume> getResumeListByMid(String mid) {
        return dao.getResumeListByMid(mid);
    }
    
    public List<ScoreComMem> getScoreComMemListByMid(String mid){
    	return dao.getScoreComMemListByMid(mid);
    }
    
    public Resume getResumeByRno(String rno) {
    	return dao.getResumeByRno(rno);
    }
    
    public List<Skill> getSkillListByRno(String rno) {
        return dao.getSkillListByRno(rno);
    }
    
    public List<Experience> getExperienceListByRno(String rno) {
        return dao.getExperienceListByRno(rno);
    }
    
    public List<Degree> getDegreeListByRno(String rno) {
        return dao.getDegreeListByRno(rno);
    }
    
    public List<Link> getLinkListByRno(String rno) {
        return dao.getLinkListByRno(rno);
    }
    //////
    
    public void submitScore(String mid, String cno, int score, String review) {
        dao.insertScore(mid, cno, score, review);
    }
    // 평점 삽입
    
    public Double getAverageScore(String mid) {
        return dao.getAverageScore(mid);
    }
}
