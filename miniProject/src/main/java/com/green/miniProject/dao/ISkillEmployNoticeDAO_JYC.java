package com.green.miniProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.miniProject.domain.SkillEmployNotice;

@Mapper
public interface ISkillEmployNoticeDAO_JYC {
	
	public List<SkillEmployNotice> getSkillEmployNoticeList(@Param("enno") Long enno);

}
