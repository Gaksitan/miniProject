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
	public int insertMem(String mid, Long bno) {
		System.out.println("mid. : " + mid);
		System.out.println("bno. : " + bno);
		int result = dao.insertLikeMem(mid, bno);
		dao.plusLikeOnBoard(bno);

		return result;

	}

	public int deleteMem(String mid, Long bno) {
		System.out.println("mid.. : " + mid);
		System.out.println("bno.. : " + bno);
		int result = dao.deleteLikeMem(mid, bno);
		dao.minusLikeOnBoard(bno);

		return result;
	}

	public int insertCom(String cmid, Long bno) {
		System.out.println("cmid... : " + cmid);
		System.out.println("bno... : " + bno);
		int result = dao.insertLikeCom(cmid, bno);
		dao.plusLikeOnBoard(bno);

		return result;

	}

	public int deleteCom(String cmid, Long bno) {
		System.out.println("cmid.... : " + cmid);
		System.out.println("bno.... : " + bno);
		int result = dao.deleteLikeCom(cmid, bno);
		dao.minusLikeOnBoard(bno);

		return result;
	}

	public boolean getLikeListMem(String mid, Long bno) {

		int result = dao.getLikeMem(mid, bno);

		if (result == 1) {

			return true;

		} else {
			return false;
		}

	}

	public boolean getLikeListCom(String cmid, Long bno) {

		int result = dao.getLikeCom(cmid, bno);
		if (result == 1) {

			return true;

		} else {
			return false;
		}

	}
}
