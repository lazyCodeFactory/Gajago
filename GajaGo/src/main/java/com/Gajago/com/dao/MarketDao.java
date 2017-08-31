package com.Gajago.com.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.Gajago.com.vo.MarketVo;
 
@Repository
public class MarketDao {
	@Autowired
	private SqlSession sqlsession;

	public List<MarketVo> selectList() {
		return sqlsession.selectList("marketItemList");
	}

}
