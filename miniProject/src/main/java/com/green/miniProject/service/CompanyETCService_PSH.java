package com.green.miniProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.miniProject.dao.ICompanyETCDao_PSH;
import com.green.miniProject.domain.ApplyResume;
import com.green.miniProject.domain.EmployNotice;
import com.green.miniProject.domain.InterestMember;

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
}
