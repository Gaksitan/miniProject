package com.green.miniProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.miniProject.domain.ExperienceEmployNotice;

@Mapper
public interface IExperienceEmployNoticeDAO_JYC {

	public List<ExperienceEmployNotice> getExperienceEmployNoticeList(@Param("enno") Long enno);
}
