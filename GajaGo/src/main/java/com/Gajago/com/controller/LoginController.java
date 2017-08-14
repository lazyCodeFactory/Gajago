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
 
//	//로그인 체크
	@RequestMapping(value = "/loginChkProc",method=RequestMethod.POST)
	public @ResponseBody HashMap<String, Object> loginChkProc(MemberVo member,HttpServletRequest request,HttpServletResponse response) {
	    logger.info(member.toString());
		HashMap<String, Object> retCheck = new HashMap<String, Object>();
		String snsUserId = request.getParameter("snsUserId");
		String profilePic = request.getParameter("profilePic");
 		if(snsUserId != null || !"".equals(snsUserId) ) {
			member.setSnsId(snsUserId);
			if(profilePic!=null || !"".equals(profilePic)) {
				member.setProfilePic(profilePic);
			}
 		}
		MemberVo resultM = new MemberVo();
		resultM= loginService.logincheck(member);
		int signSnsResult = 0;
		//회원정보가 있는경우   >> 일반 로그인
		if(resultM.getId() !=null) {
			retCheck.put("retSign", "NY");
			retCheck.put("retData", resultM);
		//SNS 회원정보가 없는경우 >> SNS로 로그인	
		}else if(resultM.getId() == null && resultM.getSnsId() == null && snsUserId ==null ) {
			retCheck.put("retSign", "N");
			retCheck.put("retMsg", "등록되지 않은 아이디이거나, 아이디 또는 비밀번호를 잘못 입력하셨습니다.");
		
		}else if(resultM.getId() == null && resultM.getSnsId() == null && snsUserId!=null){
			if(snsUserId.length() >= 1) {
				signSnsResult = loginService.signUpSns(member);
				if(signSnsResult > 0) {
					//SNS 회원가입 완료
					retCheck.put("retSign", "SY");
 					retCheck.put("retData", member);
				}else {
					retCheck.put("retSign", "N");
					retCheck.put("retMsg", "자동 로그인이 되지 않습니다 관리자에게 문의해주세요.");
				}
			}
		}
 		return retCheck;

	}
	
	
}
