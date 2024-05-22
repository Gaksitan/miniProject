package com.green.miniProject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.green.miniProject.entity.EmployNotice;
import com.green.miniProject.repository.EmployNoticeRepository;

@Service
public class EmployNoticeService_jyc {

	// 페이지네이션 서비스를 만들고 함수를 만들어서 이 안에서 리스트를 만들어서 컨트롤러로 보내게 구현한다
	
	@Autowired
	private EmployNoticeRepository employNoticeRepository;
	
	public Page<EmployNotice> getList(int page){ // 페이지를 매개변수로 받는다 기본은 0이다
		List<Sort.Order> sorts = new ArrayList<>(); // 정렬 하기 위해 정렬 배열을 만들어준다
		sorts.add(Sort.Order.asc("enenddate")); // 정렬하고 싶은 조건을 적어준다
		PageRequest pageRequest = PageRequest.of(page - 1, 10, Sort.by(sorts)); //PageRequest 안에 페이지번호, 페이지당 요소 수, 소트함수를 넣어준다
		return employNoticeRepository.findAll(pageRequest); // 리턴한다.
		
	}
}
