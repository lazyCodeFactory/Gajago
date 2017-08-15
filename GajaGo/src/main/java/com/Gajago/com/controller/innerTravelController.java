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
import org.springframework.web.servlet.ModelAndView;

import com.Gajago.com.service.InnerTravelService;

@Controller
public class innerTravelController {

	@Autowired
	InnerTravelService innerTravelService;
	private static final Logger logger = LoggerFactory.getLogger(innerTravelController.class);

	@RequestMapping(value = "/innerTrevelList")
	public ModelAndView innerTrevelList(ModelAndView model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		 List<HashMap<String,Object>> innerTravelList = new ArrayList<HashMap<String,Object>>();
		innerTravelList = innerTravelService.selectList();
		model.addObject("title", "국내여행 리스트");
		model.addObject("innerTravelList", innerTravelList);
		model.setViewName("/innerTrevel/innerTrevelList");
		return model;
	}
}
