package com.green.miniProject.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface IBlackListCheckDao_MSI {
	//블랙리스트에 id가 있으면 1 반환, 없으면 0 반환
	@Select("SELECT COUNT(*) > 0 FROM blackAccount WHERE mid = #{userId} OR cno = #{userId}")
    boolean isBlacklisted(String userId);
}
