package com.green.miniProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.miniProject.dao.IBlackListCheckDao_MSI;

@Service
public class UserService {
	@Autowired
	private IBlackListCheckDao_MSI blackAccDao;
	
	public boolean isUserBlacklisted(String userId) {
		return blackAccDao.isBlacklisted(userId);
	}
}
