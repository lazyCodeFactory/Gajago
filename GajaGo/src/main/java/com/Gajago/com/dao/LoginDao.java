package com.Gajago.com.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Gajago.com.vo.MemberVo;

@Repository
public class LoginDao {
	@Autowired
	private SqlSession sqlsession;

	public MemberVo compPassword(MemberVo member) {
		MemberVo resultVO = new MemberVo();

		resultVO = sqlsession.selectOne("loginChk",member);
		return resultVO;
	}

	public MemberVo selectCheckElement(MemberVo member) {
		MemberVo resultVo = new MemberVo();
 		resultVo = sqlsession.selectOne("selectChkEle",member);
		return resultVo;
	}

	public int signUpSns(MemberVo member) {
 		return  sqlsession.insert("insertSns", member);
	}  

}
