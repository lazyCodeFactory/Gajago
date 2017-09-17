package com.Gajago.com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gajago.com.dao.MarketDao;
import com.Gajago.com.vo.MarketVo;
import com.Gajago.com.vo.itemMarketBoardVo;

@Service
public class MarketService {
	@Autowired
	MarketDao dao;

	public List<itemMarketBoardVo> selectList() {
		List<itemMarketBoardVo> marketItemList = new ArrayList<itemMarketBoardVo>();
		marketItemList =  dao.selectList();
		return marketItemList;
	}

	public int selectCount() {
 		return dao.selectTotalCnt();
	}

	public String insertData(itemMarketBoardVo itemMarketBoard) {
 		return dao.insertData(itemMarketBoard);
	}

	public HashMap<String,Object> insertUploadFile(HashMap<String, Object> paramMap) {
		HashMap<String,Object> retCheck = new HashMap<String,Object>();
		retCheck = dao.insertUploadFile(paramMap);
		return retCheck;
	}

	public int updateFileToSeq(List<String> fileList, String maxNumber) {
		HashMap<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("fileList", fileList);
		paramMap.put("maxNumber", maxNumber);
		
		int updateSeqToFileListResult = dao.updateFileList(paramMap);
		return updateSeqToFileListResult;
	}

}
