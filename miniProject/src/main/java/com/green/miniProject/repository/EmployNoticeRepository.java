package com.green.miniProject.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.green.miniProject.entity.EmployNotice;

public interface EmployNoticeRepository extends JpaRepository<EmployNotice, Long>{
	
	Page<EmployNotice> findAll(Pageable pageable);
	
	// 페이지네이션 하고 싶은 함수에 Pageable을 매개변수로 넣어준다
}
