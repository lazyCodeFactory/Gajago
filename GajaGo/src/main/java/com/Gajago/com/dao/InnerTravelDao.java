package com.Gajago.com.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Gajago.com.vo.innerQnAcomunityVo;

@Repository
public class InnerTravelDao {
	@Autowired
	private SqlSession sqlsession;

	public int insertQnaComVo(innerQnAcomunityVo qnaCom) {
		int result = sqlsession.insert("insertQnaComVo",qnaCom);
		return result;
	}

	public List<innerQnAcomunityVo> selectQnaComVoList(String innerTravelQnaContentId) {
		List<innerQnAcomunityVo> innerQnaComList = new ArrayList<innerQnAcomunityVo>(); 		
		innerQnaComList = sqlsession.selectList("selectQnaComVoList",innerTravelQnaContentId);
		return innerQnaComList;
	}

	 
}
