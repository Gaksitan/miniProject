package com.green.miniProject.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.green.miniProject.dao.IEmployNoticeDAO_JYC;
import com.green.miniProject.domain.EmployNotice;

@SpringBootTest
public class EmployNoticeDAOTest_JYC {

	@Autowired
	private IEmployNoticeDAO_JYC iendao;
	
	@Test
	public void test() {
		
		double page = 21 / 10.0;
		System.out.println("page : " + page);
		
		System.out.println(Math.ceil(page));
		
	
	}
}
