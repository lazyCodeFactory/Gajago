package com.Gajago.com.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Gajago.com.vo.MemberVo;

@Repository
public class MemberDao {
	@Autowired
	private SqlSession sqlsession;

	public String chkJoinId(String userId) {

		String resultId = sqlsession.selectOne("checkId", userId);
		return resultId;
	}

	public int insertMember(MemberVo member) {
		System.out.println(member.toString());
		int result = sqlsession.insert("insertMember", member);
		return result;
	}

	public String chkSameId(String id) {
		String resultId  = sqlsession.selectOne("chkSameId", id);
		return resultId;
	}

}