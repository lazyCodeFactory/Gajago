package com.Gajago.com.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.Gajago.com.service.MainService;
import com.Gajago.com.service.MarketService;
import com.Gajago.com.util.FileUploader;
import com.Gajago.com.util.SessionUtil;
import com.Gajago.com.vo.MarketVo;
import com.Gajago.com.vo.MemberVo;
import com.Gajago.com.vo.itemMarketBoardVo;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class MarketController {   
	@Autowired
	MarketService marketService;

	private static final Logger logger = LoggerFactory.getLogger(MarketController.class);

	@RequestMapping(value ="/marketItemList" , method = RequestMethod.GET)
	public ModelAndView MarketTicketList(ModelAndView model, HttpServletRequest request, HttpServletResponse response,HttpSession session,MarketVo marketvo) {
		List<itemMarketBoardVo> marketlist = marketService.selectList();
 
		int currentPage = 1;
		int rowPerNNum  = 1;
		int blockPerNum = 1;
		int totalPage   = 0 ;
		int startRow    = 0;
		int endRow      = 0;
		int totalCnt    = 0;
		int startPage   = 0;
		int endPage     = 0;

		totalCnt = marketService.selectCount();
		MemberVo sessionInfo = new MemberVo();
		sessionInfo = SessionUtil.getSession(session);
 	 	
		if(request.getParameter("currentPage")!=null) { 
 			currentPage = Integer.parseInt(request.getParameter("currentPage")); 
 		}
		
		startRow = (currentPage * rowPerNNum) - (rowPerNNum-1);
		endRow = currentPage * rowPerNNum;
		
		startPage = ((currentPage -1) / blockPerNum + blockPerNum) +1;
		endPage = ((currentPage-1)/blockPerNum*blockPerNum)+blockPerNum; 

		totalPage = totalCnt / rowPerNNum;
		
		model.addObject("sessionInfo",sessionInfo);
 		model.addObject("marketlist",marketlist);
 		model.addObject("totalCnt",totalCnt);
		model.setViewName("/market/marketItemList");
	 	return model;
	}
	
	
	@RequestMapping(value ="/itemWriteAction" , method = RequestMethod.POST)
	public ModelAndView itemWriteAction(ModelAndView model, MultipartHttpServletRequest file, HttpServletResponse response,HttpSession session,itemMarketBoardVo itemMarketBoard) throws IOException {
		MemberVo sessionInfo = new MemberVo();
		int marketInsertResult = 0;
		String maxNumber = "";

		sessionInfo = SessionUtil.getSession(session);
		itemMarketBoard.setMarketWriter(sessionInfo.getNickname());
		maxNumber = marketService.insertData(itemMarketBoard);

		List<String> fileList = itemMarketBoard.getImgfile();
		
		if("".equals(maxNumber)) {
			marketInsertResult = -1;
		}else {
			if(fileList != null || fileList.size()>0) {
				marketInsertResult =marketService.updateFileToSeq(fileList,maxNumber);
			}
		}
		
		
		if(marketInsertResult >= 0) {
  			String redirectUrl = "redirect:/marketItemList";
  			model.setViewName(redirectUrl);
  			
  		}else {
  			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('오류가 발생했습니다 관리자에게 문의해주세요 '); return false;</script>");
			writer.flush();
			writer.close();
  		}
  	
  		return model;
	}
 
 	@RequestMapping(value ="/fileUpload" , method = RequestMethod.POST)
  	public @ResponseBody HashMap<String,Object> fileUpload(MultipartHttpServletRequest request,HttpServletResponse response,HttpSession session){
		HashMap<String,Object> uploadRetCheck = new HashMap<String,Object>();
		HashMap<String,Object> paramMap = new HashMap<String,Object>();
		HashMap<String,Object> retCheck = new HashMap<String,Object>();
		HashMap<String,Object> dbFileInsertMap =  new HashMap<String,Object>();
 		MemberVo sessionInfo = new MemberVo();
		sessionInfo = SessionUtil.getSession(session);
		String id = sessionInfo.getId();
		//파일 업로드
		uploadRetCheck= FileUploader.fileUpload(request);
 	 	//정상적일떄 디비에 넣기
 	 	if("Y".equals(uploadRetCheck.get("uploadSign"))){
 	 		String uploadFile= (String) uploadRetCheck.get("uploadFile");
 	 		paramMap.put("uploadId", id);
 	 		paramMap.put("uploadFile", uploadFile);
 	 		
 	 		dbFileInsertMap = marketService.insertUploadFile(paramMap);
 	 		if(dbFileInsertMap != null) {
 	 			retCheck.put("retSign", "Y");
 	 	 		retCheck.put("retImgFile", dbFileInsertMap.get("uploadFilename"));
 	 	 		retCheck.put("retImgFileIdx", dbFileInsertMap.get("uploadFileIdx"));

 	 		}else {
 	 			retCheck.put("retSign", "N");
 	 	 		retCheck.put("retMsg", "파일업로드가 되지않았습니다");
 	 		}
 	 		
 	 	}else {
 	 		retCheck.put("retSign", "N");
 	 		retCheck.put("retMsg", "파일업로드가 되지않았습니다");

 	 	}
 		return retCheck;
 	}
 }





