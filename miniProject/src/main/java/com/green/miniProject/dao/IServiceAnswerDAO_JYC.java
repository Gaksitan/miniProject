package com.green.miniProject.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IServiceAnswerDAO_JYC {

	public String getSacontent(@Param("sqno") Long sqno);
}
