package com.green.miniProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.miniProject.domain.ServiceQuestion;

@Mapper
public interface IServiceQuestionDAO_JYC {

	public void registServiceQuestionMem(@Param("sq") ServiceQuestion sq);
	public void registServiceQuestionCom(@Param("sq") ServiceQuestion sq);

	public List<ServiceQuestion> getServiceQuestionListForMem(@Param("mid") String mid);
	public List<ServiceQuestion> getServiceQuestionListForCom(@Param("cno") String cno);

	public ServiceQuestion getServiceQuestion(@Param("sqno") Long sqno);
	
	public void deleteServiceQuestion(@Param("sqno") Long sqno);
}
