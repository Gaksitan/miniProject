package com.green.miniProject.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.green.miniProject.entity.EmployNotice;

public interface EmployNoticeRepository extends JpaRepository<EmployNotice, Long>{
	
	Page<EmployNotice> findAll(Pageable pageable);
}
