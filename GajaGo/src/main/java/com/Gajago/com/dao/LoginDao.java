package com.Gajago.com.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDao {
	@Autowired
	private SqlSession sqlsession;

	public String chkJoinId(String userId) {
 
		String resultId = sqlsession.selectOne("checkId",userId);		 
		return resultId;
	}

}
