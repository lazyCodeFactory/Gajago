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

	//�α��� 
	public MemberVo logincheck(MemberVo member) {
		StringUtil st = new StringUtil();
		MemberVo resultVo =  new MemberVo();
		String encryPassword  = "";
		String paramPassword = "";
 		MemberVo checkElem  = new MemberVo();
 		
 	    checkElem = dao.selectCheckElement(member);
 	    if(checkElem != null) {
 	    	paramPassword = checkElem.getPassword();
 	    
  	    
 		
 			//�ʱ�ȭ �ؼ�  ���Ϸ� �������
			if("Y".equals(checkElem.getInitYn())) {
			//sns���� �α��� �������� ����
			}else if(checkElem.getSnsId()!=null || "".equals(checkElem.getSnsId())) {
			//������ ��й�ȣ �Է��ߴ� �������� �α��� 
			}else {
				encryPassword = st.encryptSha256(paramPassword);
				member.setPassword(encryPassword);
			}
			resultVo = dao.compPassword(checkElem);
 	    }
 		return resultVo;
	}
//SNS ȸ������
	public int signUpSns(MemberVo member) {
		int result = 0 ;
		result = dao.signUpSns(member);
		return result;
	}
}
