package com.green.miniProject.dao;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.miniProject.domain.Admin;
import com.green.miniProject.domain.BlackAccount;
import com.green.miniProject.domain.FAQ;
import com.green.miniProject.domain.Notice;
import com.green.miniProject.domain.ServiceQuestion;

@Mapper
public interface IAdminDao_MSI {
	public List<Admin> getAdminDao(String aid);
	
	public int writeNotice(String ano, String ntitle, String ncontent, String nregdate);

	public int updateNotice(@Param("notice") Notice notice);
	
	public int deleteNotice(@Param("nno") String nno);
	
	public List<ServiceQuestion> noAnswerList();
	
	public ServiceQuestion getQuestion(@Param("sqno")String sqno);
	
	public int writeServiceAnswer(@Param("sqno")String sqno, @Param("sacontent")String sacontent, @Param("saregdate")LocalDate saregdate);

	public List<FAQ> getFaqList();
	
	public int writeFAQ(@Param("faq") FAQ faq);
	
	public List<BlackAccount> getBlackList();
	
	public int deleteBlackList(@Param("bano")String bano);
}
