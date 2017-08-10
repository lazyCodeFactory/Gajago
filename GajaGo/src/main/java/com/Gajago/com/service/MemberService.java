package com.Gajago.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gajago.com.dao.MemberDao;
import com.Gajago.com.vo.MemberVo;

@Service
public class MemberService {
	@Autowired
	MemberDao dao;

	public int insertMember(MemberVo member) {
			int result= dao.insertMember(member);
			
		return result;
	}

	public String selectSameId(String Id) {
		String resultId  = dao.chkSameId(Id); 
		return resultId;
	}
 
}
