package com.green.miniProject.service;

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
    
    public Member getApplicantDetailByMid(String mid) {
        return dao.getApplicantDetailByMid(mid);
    }

    public List<Resume> getResumeListByMid(String mid) {
        return dao.getResumeListByMid(mid);
    }
    
    public List<Skill> getSkillListByMid(String mid) {
        return dao.getSkillListByMid(mid);
    }
    
    public List<Experience> getExperienceListByMid(String mid) {
        return dao.getExperienceListByMid(mid);
    }
    
    public List<Degree> getDegreeListByMid(String mid) {
        return dao.getDegreeListByMid(mid);
    }
    
    public List<Link> getLinkListByMid(String mid) {
        return dao.getLinkListByMid(mid);
    }
    
}
