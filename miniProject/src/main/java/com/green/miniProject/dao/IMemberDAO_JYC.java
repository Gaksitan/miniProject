package com.green.miniProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.miniProject.domain.Company;
import com.green.miniProject.domain.Member;

@Mapper
public interface IMemberDAO_JYC {
	public List<Member> getMemberList(@Param("keyword") String keyword);
}
