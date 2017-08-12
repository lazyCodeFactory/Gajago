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
import com.Gajago.com.vo.MemberVo;

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
 //중복아이디 있는지 확인 
//	@RequestMapping(value = "/loginChkProc", method = RequestMethod.POST)
//	public @ResponseBody HashMap<String, Object> loginChkProc(HttpServletRequest request,
//			HttpServletResponse response) {
//		HashMap<String, Object> retCheck = new HashMap<String, Object>();
//		String userId = request.getParameter("userId");
//		boolean isExistID = loginService.chkJoinId(userId);
//		if (isExistID == true) {
//			retCheck.put("retSign", "Y");
//			retCheck.put("retData", userId);
//		} else {
//			retCheck.put("retSign", "N");
//		}
//		return retCheck;
//
//	}
//	
	
	@RequestMapping(value = "/loginChkProc", method = RequestMethod.POST)
	public @ResponseBody HashMap<String, Object> loginChkProc(MemberVo member,HttpServletRequest request,
			HttpServletResponse response) {
		HashMap<String, Object> retCheck = new HashMap<String, Object>();
		MemberVo resultM = new MemberVo();
		resultM= loginService.logincheck(member);
		
		if(resultM !=null) {
			retCheck.put("retSign", "Y");
			retCheck.put("retData", resultM);
		}else {
			retCheck.put("retSign", "N");
			retCheck.put("retMsg", "아이디와 비밀번호 확인을 부탁드립니다");
		}
		return retCheck;

	}
	
	
	
}
