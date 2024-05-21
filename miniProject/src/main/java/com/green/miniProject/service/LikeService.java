package com.green.miniProject.service;

import org.springframework.stereotype.Service;

import com.green.miniProject.dao.ICommuDao_KHJ;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LikeService {

	private final ICommuDao_KHJ dao;
	
	@Transactional
	public int insert(String mid, Long bno) {
		System.out.println("mid : " + mid);
		System.out.println("bno : " + bno);
		int result = dao.insertLikeMem(mid, bno);
		dao.plusLikeOnBoard(bno);
		
		return result;
		
	}
	
	public int delete(String mid, Long bno) {
		System.out.println("mid : " + mid);
		System.out.println("bno : " + bno);
		int result = dao.deleteLikeMem(mid, bno);
		dao.minusLikeOnBoard(bno);
		
		return result;
	}
	
}
