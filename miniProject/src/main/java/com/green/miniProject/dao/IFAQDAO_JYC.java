package com.green.miniProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.miniProject.domain.FAQ;

@Mapper
public interface IFAQDAO_JYC {

	public List<FAQ> getFAQListTargetMem(@Param("keyword") String keyword);
	public List<FAQ> getFAQListTargetCom(@Param("keyword") String keyword);
}
