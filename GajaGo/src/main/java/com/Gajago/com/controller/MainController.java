package com.Gajago.com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Gajago.com.service.MainService;
import com.Gajago.com.util.SessionUtil;
import com.Gajago.com.vo.MemberVo;

@Controller
public class MainController {
	@Autowired
	MainService mainService;

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@RequestMapping(value = "/main")
	public ModelAndView findInfo(ModelAndView model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		String mainName = request.getParameter("mainName");
		String mainProfileImg = request.getParameter("mainProfileImg");
		MemberVo sessionInfo = new MemberVo();
		sessionInfo = SessionUtil.getSession(session);
 		model.addObject("sessionInfo",sessionInfo);
		model.addObject("title", "메인화면");
		model.addObject("mainName",mainName);
		model.addObject("mainProfileImg",mainProfileImg);
		model.setViewName("/main/main");
		return model;
	}
 }





