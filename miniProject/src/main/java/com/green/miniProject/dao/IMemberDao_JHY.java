package com.green.miniProject.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.miniProject.domain.Member;

@Mapper
public interface IMemberDao_JHY {
	public void get();
	public Member loginCheck(@Param("mid")String mid, @Param("mpw")String mpw);
}
