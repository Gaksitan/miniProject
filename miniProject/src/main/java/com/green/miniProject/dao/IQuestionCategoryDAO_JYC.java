package com.green.miniProject.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IQuestionCategoryDAO_JYC {

	public Long getQcno(@Param("category") String category);
}
