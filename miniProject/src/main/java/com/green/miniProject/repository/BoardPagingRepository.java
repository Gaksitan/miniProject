package com.green.miniProject.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.green.miniProject.entity.Board;

public interface BoardPagingRepository extends JpaRepository<Board, Long>{

	Page<Board> findAll(Pageable pageable);
	Page<Board> findByMidIsNotNull(Pageable pageable);
	Page<Board> findByCmidIsNotNull(Pageable pageable);
	
}
