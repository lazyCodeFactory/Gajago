package com.Gajago.com.dao;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.Gajago.com.vo.MarketVo;
import com.Gajago.com.vo.itemMarketBoardVo;
 
@Repository
public class MarketDao {
	@Autowired
	private SqlSession sqlsession;

	public List<itemMarketBoardVo> selectList() {
		return sqlsession.selectList("marketItemList");
	}

	public int selectTotalCnt() {
 		return sqlsession.selectOne("selectCount");
	}

	public String insertData(itemMarketBoardVo itemMarketBoard) {
		System.out.println("최종 파라미터 "+itemMarketBoard.toString());
		sqlsession.selectOne("insertData", itemMarketBoard);
		String getMaxIdx = itemMarketBoard.getMaxIdx();
 		return getMaxIdx;
	}

	public HashMap<String,Object> insertUploadFile(HashMap<String, Object> paramMap) {
 		return sqlsession.selectOne("insertUploadFile", paramMap);
	}


	public int updateFileList(HashMap<String, Object> paramMap) {
		return sqlsession.update("updateFileList", paramMap);
	}

}
