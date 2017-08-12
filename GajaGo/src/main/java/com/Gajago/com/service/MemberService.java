package com.Gajago.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gajago.com.dao.MemberDao;
import com.Gajago.com.util.EmailSender;
import com.Gajago.com.util.StringUtil;
import com.Gajago.com.vo.EmailVo;
import com.Gajago.com.vo.MemberVo;

@Service
public class MemberService {
	@Autowired
	private MemberDao dao;
 
	public int insertMember(MemberVo member) {
		int result= dao.insertMember(member);
		return result;
	}

	public String selectSameId(String Id) {
		String resultId  = dao.chkSameId(Id); 
		return resultId;
	}

	

	public MemberVo findId(String name, String email) {
 		MemberVo paramVo = new MemberVo();
	    paramVo.setName(name);	
	    paramVo.setEmail(email);
	    MemberVo resultVo = dao.findId(paramVo);
	    return resultVo;
	}

	public int findPwd(MemberVo member) {
		//���� �Ķ����
		String password = dao.findPwd(member);
		//�ӽ� ��й�ȣ
		String randomPwd ="";
  		EmailVo emailVo = new EmailVo();
		int result = 0;
		if(password != null || !"".equals(password)) {
			randomPwd = StringUtil.randowPwdInit(10);
			member.setPassword(randomPwd);
			//�ӽ� ��й�ȣ�� ������Ʈ ħ
			result = dao.initPwd(member);
			if(result > 0 ) {
				emailVo.setContent("��й�ȣ�� "+randomPwd+"�Դϴ�");
				emailVo.setReceiver(member.getEmail());
			    emailVo.setSubject(""+member.getId()+"�� ��й�ȣ ã�� ���� �ȳ��Դϴ�");
			    EmailSender emailSender = new EmailSender();
			    emailSender.sendEMail(emailVo);
			}
		}
 		return result;
	}
}
