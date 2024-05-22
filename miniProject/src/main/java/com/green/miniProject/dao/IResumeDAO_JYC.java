package com.green.miniProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.miniProject.domain.Resume;

@Mapper
public interface IResumeDAO_JYC {

	public List<Resume> getResumeList(@Param("mid") String mid);
	public Resume getMainResume(@Param("mid") String mid);
}
