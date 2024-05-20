package com.green.miniProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.miniProject.domain.ScoreMemCom;

@Mapper
public interface IScoreMemComDAO_JYC {

	public List<ScoreMemCom> getScoreMemComList(@Param("cno") String cno);
}
