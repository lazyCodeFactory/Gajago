package com.Gajago.com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.Gajago.com.service.InnerTravelService;

@Controller
public class innerTravelController {

	@Autowired
	InnerTravelService innerTravelService;
	private static final Logger logger = LoggerFactory.getLogger(innerTravelController.class);

	@RequestMapping(value = "/innerTravelList", method = RequestMethod.GET)
	public ModelAndView innerTrevelList(ModelAndView model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<HashMap<String,Object>> innerTravelList = new ArrayList<HashMap<String,Object>>();
		String areaCode = "1";
		String cateCode="25";
		innerTravelList = innerTravelService.selectList(areaCode,cateCode);
		model.addObject("title", "국내여행 리스트");
		System.out.println("innerTravelList >>>>>>>>>>>>>"+innerTravelList.toString());
		model.addObject("innerTravelList", innerTravelList);
		model.setViewName("/innerTravel/innerTravelList");
		return model;
	}
	

 
	
	@RequestMapping(value = "/innerListProc")
	public @ResponseBody HashMap<String,Object> getinnerTrevelList(ModelAndView model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		HashMap<String,Object> retCheck = new HashMap<String,Object>();
		String areaCode = request.getParameter("areaCode");
		String cateCode = request.getParameter("cateCode");
		
		if(areaCode== null || "".equals(areaCode) ) {
			areaCode="";
		}
		if(cateCode== null || "".equals(cateCode) ) {
			cateCode="";
		}
		 
		
		List<HashMap<String,Object>> innerTravelList = new ArrayList<HashMap<String,Object>>();
		innerTravelList = innerTravelService.selectList(areaCode,cateCode);
		retCheck.put("retSign", "Y");
		retCheck.put("retData", innerTravelList);
		
		return retCheck;
	}    
	@RequestMapping(value = "/innerTravelDetail",method = RequestMethod.POST)
	public ModelAndView innerTravelDetail(ModelAndView model,HttpServletRequest request,HttpServletResponse response) throws IOException {
		String cateCode =  request.getParameter("cateCode");
		String contentId = request.getParameter("contentId");
		
		HashMap<String,Object> travelMap  = innerTravelService.selectOne(cateCode,contentId);
		System.out.println("travelMap >>>>>>>>>>>>>>>>"+travelMap.toString());
 		
		model.setViewName("/innerTravel/innerTravelDetail");
		return model;
	} 
	
	
}
