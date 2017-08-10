package com.Gajago.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gajago.com.dao.LoginDao;

@Service
public class LoginService {
	@Autowired
	LoginDao dao;

	public boolean chkJoinId(String userId) {
		boolean result =  false;
		
		String resultId = dao.chkJoinId(userId);
		
		if(resultId == null || "".equals(resultId)) {
			result = false;
		}else {
			result = true;
		}
		return result;
	}
}
