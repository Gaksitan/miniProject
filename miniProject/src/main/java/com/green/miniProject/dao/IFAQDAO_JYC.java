package com.green.miniProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.miniProject.domain.FAQ;
import com.green.miniProject.domain.FAQDetail;

@Mapper
public interface IFAQDAO_JYC {

	public List<FAQDetail> searchFAQListTargetMem(@Param("keyword") String keyword);
	public List<FAQDetail> searchFAQListTargetCom(@Param("keyword") String keyword);

	public List<FAQDetail> getFAQListTargetMem();
	public List<FAQDetail> getFAQListTargetCom();
}
