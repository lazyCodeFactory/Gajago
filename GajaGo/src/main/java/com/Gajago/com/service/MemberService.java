package com.Gajago.com.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.Gajago.com.dao.MemberDao;
import com.Gajago.com.util.StringUtil;
import com.Gajago.com.vo.EmailVo;
import com.Gajago.com.vo.MemberVo;

@Service
public class MemberService {
	@Autowired
	private MemberDao dao;
	 @Autowired
	 private JavaMailSender mailSender;
	 
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
			   
			    try {
			        MimeMessage message = mailSender.createMimeMessage();
			        MimeMessageHelper messageHelper= new MimeMessageHelper(message, true, "UTF-8");
			   
			        messageHelper.setFrom("gajago84@gmail.com");  // �����»�� �����ϰų� �ϸ� �����۵��� ����
			        messageHelper.setTo(emailVo.getReceiver());     // �޴»�� �̸���
			        messageHelper.setSubject(emailVo.getSubject()); // ���������� ������ �����ϴ�
			        messageHelper.setText(emailVo.getContent());  // ���� ����
 			        mailSender.send(message);
			      } catch(Exception e){
			        System.out.println(e);
			      }
	 		    
			}
		}
 		return result;
	}
}
