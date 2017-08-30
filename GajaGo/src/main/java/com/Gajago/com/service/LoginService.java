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
  		int updateSnsResult = 0;
  		//아이디 체크
  		
  		resultVo = dao.compId(member);
   		//비밀번호 체크 
 	    if(resultVo != null) {
 	    	paramPassword = member.getPassword();
 	 			//초기화 해서  메일로 보낸경우
			if("Y".equals(member.getInitYn())) {
				resultVo = dao.compPassword(member);

			//sns으로 로그인 했을경우는 제외
			}else if(member.getSnsId()!=null || !"".equals(member.getSnsId())) {
			   //sns 정보 업데이트 하고 난뒤에 셀렉트 해서 정보 뺴기 
				try {
					updateSnsResult =  dao.updaetSnsInfo(member);
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}else {
				encryPassword = st.encryptSha256(paramPassword);
 				member.setPassword(encryPassword);
 				resultVo = dao.compPassword(member);

			}
			
		
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
