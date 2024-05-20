package com.green.miniProject.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ISubscribeCompanyDAO_JYC {

	public void subscribeCompany(@Param("mid") String mid, @Param("cno") String cno);
	public void unsubscribeCompany(@Param("mid") String mid, @Param("cno") String cno);
	public int count(@Param("mid") String mid, @Param("cno") String cno);
	
	
}
