package com.Gajago.com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
//	@Autowired
//	LoginService loginservice;


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(ModelAndView model, HttpServletRequest request, HttpServletResponse response) {
		model.setViewName("/login/login");
		return model;
	}

	@RequestMapping(value = "/findInfo", method = RequestMethod.GET)
	public ModelAndView findInfo(ModelAndView model, HttpServletRequest request, HttpServletResponse response) {
		model.setViewName("/member/findInfo");
		return model;
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public ModelAndView signUp(ModelAndView model, HttpServletRequest request, HttpServletResponse response) {
		model.setViewName("/member/signUp");
		return model;
	}

}
