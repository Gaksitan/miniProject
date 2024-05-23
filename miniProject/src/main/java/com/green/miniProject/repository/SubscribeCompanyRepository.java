package com.green.miniProject.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.green.miniProject.entity.SubscribeCompany;

public interface SubscribeCompanyRepository extends JpaRepository<SubscribeCompany, Long>{

	Page<SubscribeCompany> findAll(Pageable pageable);
}
