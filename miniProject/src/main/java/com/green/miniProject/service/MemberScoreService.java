package com.green.miniProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.miniProject.dao.IMemberDao_JHY;

@Service
public class MemberScoreService {
	@Autowired
	IMemberDao_JHY dao;
	
	public void submitScore(String mid, String cno, int score, String review) {
        dao.insertScore(mid, cno, score, review);
    }
}
