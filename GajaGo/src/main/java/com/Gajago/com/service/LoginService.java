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
  		int updateSnsResult = 0;
  		//���̵� üũ
  		
  		resultVo = dao.compId(member);
   		//��й�ȣ üũ 
 	    if(resultVo != null) {
 	    	paramPassword = member.getPassword();
 	 			//�ʱ�ȭ �ؼ�  ���Ϸ� �������
			if("Y".equals(member.getInitYn())) {
				resultVo = dao.compPassword(member);

			//sns���� �α��� �������� ����
			}else if(member.getSnsId()!=null || !"".equals(member.getSnsId())) {
			   //sns ���� ������Ʈ �ϰ� ���ڿ� ����Ʈ �ؼ� ���� ���� 
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
//SNS ȸ������
	public int signUpSns(MemberVo member) {
		int result = 0 ;
		result = dao.signUpSns(member);
		return result;
	}
}
