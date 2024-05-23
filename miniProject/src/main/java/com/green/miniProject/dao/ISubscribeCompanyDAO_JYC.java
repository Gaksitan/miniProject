package com.green.miniProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.miniProject.domain.SubscribeCompanyDetail;

@Mapper
public interface ISubscribeCompanyDAO_JYC {

	public void subscribeCompany(@Param("mid") String mid, @Param("cno") String cno);
	public int unsubscribeCompany(@Param("mid") String mid, @Param("cno") String cno);
	public int count(@Param("mid") String mid, @Param("cno") String cno);
	public List<SubscribeCompanyDetail> getSubComDetail(@Param("mid") String mid);
	
}
