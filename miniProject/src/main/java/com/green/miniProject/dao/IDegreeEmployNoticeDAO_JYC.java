package com.green.miniProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.miniProject.domain.DegreeEmployNotice;

@Mapper
public interface IDegreeEmployNoticeDAO_JYC {

	public List<DegreeEmployNotice> getDegreeEmployNoticeList(@Param("enno") Long enno);

}
