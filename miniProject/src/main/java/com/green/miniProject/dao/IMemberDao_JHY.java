package com.green.miniProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.miniProject.domain.JoinApplyResumeList;
import com.green.miniProject.domain.Member;
import com.green.miniProject.domain.Resume;

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
	
	
}
