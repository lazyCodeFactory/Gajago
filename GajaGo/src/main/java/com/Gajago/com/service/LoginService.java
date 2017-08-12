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

	//·Î±×ÀÎ 
	public MemberVo logincheck(MemberVo member) {
		StringUtil st = new StringUtil();
		MemberVo resultVo =  new MemberVo();
		String encryPassword  = "";
 		String paramPassword = member.getPassword();

		if (paramPassword.length() < 8 || paramPassword.length() > 16) {
		} else {
			encryPassword = st.encryptSha256(paramPassword);
			member.setPassword(encryPassword);
			resultVo = dao.compPassword(member);
		}
		return resultVo;
	}
}
