package com.green.miniProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.miniProject.domain.QuestionCategory;

@Mapper
public interface IQuestionCategoryDAO_JYC {

	public Long getQcno(@Param("category") String category);
	public String getQcname(@Param("qcno") Long qcno);
	public List<QuestionCategory> getAllQuestionCategoryList();
}
