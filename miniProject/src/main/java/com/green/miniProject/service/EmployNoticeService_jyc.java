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

	@Autowired
	private EmployNoticeRepository employNoticeRepository;
	
	public Page<EmployNotice> getList(int page){
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.asc("enenddate"));
		PageRequest pageRequest = PageRequest.of(page - 1, 10, Sort.by(sorts));
		return employNoticeRepository.findAll(pageRequest);
	}
}
