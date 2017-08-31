package com.Gajago.com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Gajago.com.service.MainService;
import com.Gajago.com.service.MarketService;
import com.Gajago.com.util.SessionUtil;
import com.Gajago.com.vo.MarketVo;
import com.Gajago.com.vo.MemberVo;

@Controller
public class MarketController {   
	@Autowired
	MarketService marketService;

	private static final Logger logger = LoggerFactory.getLogger(MarketController.class);

	@RequestMapping(value ="/marketItemList" , method = RequestMethod.GET)
	public ModelAndView MarketTicketList(ModelAndView model, HttpServletRequest request, HttpServletResponse response,HttpSession session,MarketVo marketvo) {
		List<MarketVo> marketlist = marketService.selectList();
		model.setViewName("/market/marketItemList");

	 	return model;
	}
	
	@RequestMapping(value = "/MarketItemWrite")
	public ModelAndView MarketItemWrite(ModelAndView model, HttpServletRequest request, HttpServletResponse response,HttpSession session,MarketVo marketvo) {
		model.setViewName("/market/MarketItemWrite");
		return model;
	}
 
	
	
 }





