package com.Gajago.com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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

import com.Gajago.com.service.MemberService;
import com.Gajago.com.util.StringUtil;
import com.Gajago.com.vo.MemberVo;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@RequestMapping(value = "/findInfo", method = RequestMethod.GET)
	public ModelAndView findInfo(ModelAndView model, HttpServletRequest request, HttpServletResponse response) {
		model.addObject("title", "회원정보 찾기");
		model.setViewName("/member/findInfo");
		return model;
	}

	@RequestMapping(value = "/signUp")
	public ModelAndView signUp(MemberVo member, ModelAndView model, HttpServletRequest request,HttpServletResponse response) {
		model.addObject("title", "회원가입");
		model.addObject("member", member);
		model.setViewName("/member/signUp");
		return model;
	}

	@RequestMapping("/checkSameId")
	public @ResponseBody HashMap<String,Object> checkSameId (HttpServletRequest request,HttpServletRequest response){
		HashMap<String,Object> retCheck = new HashMap<String,Object>();
	    String Id = request.getParameter("id");
		String resultId= memberService.selectSameId(Id);
		if("".equals(resultId) || resultId ==null) {
			retCheck.put("retSign", "Y");
			retCheck.put("retMsg", "[["+Id+"]] 는 사용 가능합니다 ");
			
		}else {
			retCheck.put("retSign", "N");
			retCheck.put("retMsg", "[["+Id+"]] 는 다른 분이 사용중이네요 다른 아이디를 입력해주세요");
			
		}
		
		return retCheck;
	}
	
	
	@RequestMapping(value = "/insertProc", method = RequestMethod.POST)
	public void insertProc(MemberVo member, ModelAndView model, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String password= member.getPassword();
		StringUtil st =  new StringUtil();
		String encPassword ="";
		if(password != null) {
			encPassword = st.encryptSha256(password);
		}
		member.setPassword(encPassword);
		int result = 0;
		try {
			result = memberService.insertMember(member);
			if(result >0) {
					PrintWriter writer = response.getWriter();
					writer.println("<script>alert('회원가입 완료 했습니다'); location.href='/main';</script>");
					writer.flush();
					writer.close();
			}else {
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert('오류가 발생했습니다 관리자에게 문의해주세요 '); return false;</script>");
				writer.flush();
				writer.close();
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('오류가 발생했습니다 관리자에게 문의해주세요 '); location.href='/signUp';</script>");
			writer.flush();
			writer.close();
		}
 	}

	@RequestMapping("/findId")
	public @ResponseBody HashMap<String,Object> findId (HttpServletRequest request,HttpServletRequest response){
		HashMap<String,Object> retCheck = new HashMap<String,Object>();
	    String name = request.getParameter("name");
	    String email = request.getParameter("email");
	    
	    MemberVo resultVo = new MemberVo();
	    
	    resultVo =  memberService.findId(name,email);
	    if(resultVo !=null) {
	    	retCheck.put("retSign", "Y");
	    	retCheck.put("retData",resultVo);
	    	
	    }else {
	    	retCheck.put("retSign", "N");
	    	retCheck.put("retMsg","아이디가 존재하지 않습니다");
	    	
	    }
	    return retCheck;
	    
	}
	
	//비밀번호 찾기
	@RequestMapping("/findPwd")
	public @ResponseBody HashMap<String,Object> findPwd (MemberVo member,HttpServletRequest request,HttpServletRequest response) throws UnsupportedEncodingException{
		HashMap<String,Object> retCheck = new HashMap<String,Object>();
	    int result  = memberService.findPwd(member);
	    if(result <= 0) {
	    	retCheck.put("retCheck", "N");
	    	retCheck.put("retMsg", "입력정보를 확인해주세요");
		    	
	    }else {
	    	retCheck.put("retCheck", "Y");
	    	retCheck.put("retMsg", member.getEmail()+"으로 비밀번호 정보를 전송하였습니다 ");
	    }
	    return retCheck;
	}

}





