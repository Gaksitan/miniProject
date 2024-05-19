package com.green.miniProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.miniProject.domain.Member;
import com.green.miniProject.domain.Resume;

@Mapper
public interface IMemberDao_JHY {
	public void regist(@Param("member")Member member);
	public List<Resume> getResumeList();
	public Member loginCheck(@Param("mid")String mid, @Param("mpw")String mpw);
}
