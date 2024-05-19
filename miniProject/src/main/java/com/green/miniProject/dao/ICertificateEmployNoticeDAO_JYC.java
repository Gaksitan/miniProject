package com.green.miniProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.miniProject.domain.CertificateEmployNotice;
import com.green.miniProject.domain.PreferenceEmployNotice;
import com.green.miniProject.domain.SkillEmployNotice;
import com.green.miniProject.domain.WelfareEmployNotice;

@Mapper
public interface ICertificateEmployNoticeDAO_JYC {
	
	public List<CertificateEmployNotice> getCertificateEmployNoticeList(@Param("enno") Long enno);

}
