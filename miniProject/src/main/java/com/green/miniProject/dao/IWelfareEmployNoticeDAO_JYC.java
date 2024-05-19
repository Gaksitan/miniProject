package com.green.miniProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.miniProject.domain.SkillEmployNotice;
import com.green.miniProject.domain.WelfareEmployNotice;

@Mapper
public interface IWelfareEmployNoticeDAO_JYC {
	
	public List<WelfareEmployNotice> getWelfareEmployNoticeList(@Param("enno") Long enno);

}
