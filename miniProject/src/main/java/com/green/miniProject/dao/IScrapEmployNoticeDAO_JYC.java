package com.green.miniProject.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IScrapEmployNoticeDAO_JYC {

	public void scrapEmployNotice(@Param("enno") Long enno, @Param("mid") String mid);
	public int count(@Param("enno") Long enno, @Param("mid") String mid);
	public void unscrapEmployNotice(@Param("enno") Long enno, @Param("mid") String mid);
}
