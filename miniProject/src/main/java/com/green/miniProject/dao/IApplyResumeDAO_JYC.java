package com.green.miniProject.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IApplyResumeDAO_JYC {

	public int applyResume(@Param("enno") Long enno, @Param("rno") Long rno);
	
	public int getCount(@Param("enno") Long enno, @Param("rno") Long rno);
	
}
