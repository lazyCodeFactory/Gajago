package com.Gajago.com.controller;

import java.util.HashMap;

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

import com.Gajago.com.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(ModelAndView model, HttpServletRequest request, HttpServletResponse response) {
		model.addObject("title", "로그인");
		model.setViewName("/login/login");
		return model;
	}

	@RequestMapping(value = "/loginChkProc", method = RequestMethod.POST)
	public @ResponseBody HashMap<String, Object> loginChkProc(HttpServletRequest request,
			HttpServletResponse response) {
		HashMap<String, Object> retCheck = new HashMap<String, Object>();
		String userId = request.getParameter("userId");
		boolean isExistID = loginService.chkJoinId(userId);
		if (isExistID == true) {
			retCheck.put("retSign", "Y");
			retCheck.put("retData", userId);
		} else {
			retCheck.put("retSign", "N");
		}
		return retCheck;

	}
}
