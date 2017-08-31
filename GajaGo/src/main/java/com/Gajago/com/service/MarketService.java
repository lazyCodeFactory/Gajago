package com.Gajago.com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gajago.com.dao.MarketDao;
import com.Gajago.com.vo.MarketVo;

@Service
public class MarketService {
	@Autowired
	MarketDao dao;

	public List<MarketVo> selectList() {
		List<MarketVo> marketItemList = new ArrayList<MarketVo>();
		marketItemList =  dao.selectList();
		return marketItemList;
	}

}
