package com.green.miniProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.miniProject.domain.PreferenceEmployNotice;
import com.green.miniProject.domain.SkillEmployNotice;
import com.green.miniProject.domain.WelfareEmployNotice;

@Mapper
public interface IPreferenceEmployNoticeDAO_JYC {
	
	public List<PreferenceEmployNotice> getPreferenceEmployNoticeList(@Param("enno") Long enno);

}
