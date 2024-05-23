package com.green.miniProject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.green.miniProject.entity.Board;
import com.green.miniProject.repository.BoardPagingRepository;

@Service
public class BoardPaingService_KHJ {
	// 페이지네이션 서비스를 만들고 함수를 만들어서 이 안에서 리스트를 만들어서 컨트롤러로 보내게 구현한다
	@Autowired
	private BoardPagingRepository boardPagingRepository;
	
//	public Page<Board> getList(int page){ // 페이지를 매개변수로 받는다 기본은 1이다
//		List<Sort.Order> sorts = new ArrayList<>(); // 정렬 하기 위해 정렬 배열을 만들어준다
//		sorts.add(Sort.Order.desc("bregdate")); // 정렬하고 싶은 조건을 적어준다
//		PageRequest pageRequest = PageRequest.of(page -1, 10, Sort.by(sorts)); //PageRequest 안에 페이지번호, 페이지당 요소 수, 소트함수를 넣어준다
//		return boardPagingRepository.findAll(pageRequest); // 리턴한다.
//
//	}
	
	public Page<Board> getListForMember(int page) {
		
		List<Sort.Order> sorts = new ArrayList<>(); // 정렬 하기 위해 정렬 배열을 만들어준다
		sorts.add(Sort.Order.desc("bregdate")); // 정렬하고 싶은 조건을 적어준다
		PageRequest pageRequest = PageRequest.of(page - 1, 10, Sort.by(sorts)); // 페이지 번호는 0부터 시작
        return boardPagingRepository.findByMidIsNotNull(pageRequest);
    }

    public Page<Board> getListForCompany(int page) {
    	List<Sort.Order> sorts = new ArrayList<>(); // 정렬 하기 위해 정렬 배열을 만들어준다
		sorts.add(Sort.Order.desc("bregdate")); // 정렬하고 싶은 조건을 적어준다
		PageRequest pageRequest = PageRequest.of(page - 1, 10, Sort.by(sorts)); // 페이지 번호는 0부터 시작
        return boardPagingRepository.findByCmidIsNotNull(pageRequest);
    }
	
}
