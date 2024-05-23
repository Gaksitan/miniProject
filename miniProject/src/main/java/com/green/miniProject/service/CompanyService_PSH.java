package com.green.miniProject.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.miniProject.dao.ICompanyDao_PSH;

@Service
public class CompanyService_PSH {
	@Autowired
    private SqlSession sqlSession;
	
	@Autowired
	private ICompanyDao_PSH dao;
}
