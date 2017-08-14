package com.Gajago.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gajago.com.dao.LoginDao;
import com.Gajago.com.util.StringUtil;
import com.Gajago.com.vo.MemberVo;

@Service
public class LoginService {
	@Autowired
	LoginDao dao;

	//로그인 
	public MemberVo logincheck(MemberVo member) {
		StringUtil st = new StringUtil();
		MemberVo resultVo =  new MemberVo();
		String encryPassword  = "";
		String paramPassword = "";
 		MemberVo checkElem  = new MemberVo();
 		
 	    checkElem = dao.selectCheckElement(member);
 	    if(checkElem != null) {
 	    	paramPassword = checkElem.getPassword();
 	    
  	    
 		
 			//초기화 해서  메일로 보낸경우
			if("Y".equals(checkElem.getInitYn())) {
			//sns으로 로그인 했을경우는 제외
			}else if(checkElem.getSnsId()!=null || "".equals(checkElem.getSnsId())) {
			//나머지 비밀번호 입력했는 정상적인 로그인 
			}else {
				encryPassword = st.encryptSha256(paramPassword);
				member.setPassword(encryPassword);
			}
			resultVo = dao.compPassword(checkElem);
 	    }
 		return resultVo;
	}
//SNS 회원가입
	public int signUpSns(MemberVo member) {
		int result = 0 ;
		result = dao.signUpSns(member);
		return result;
	}
}
