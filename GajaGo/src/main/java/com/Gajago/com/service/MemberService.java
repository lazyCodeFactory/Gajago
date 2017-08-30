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
		//디비속 파라미터
		String password = dao.findPwd(member);
		//임시 비밀번호
		String randomPwd ="";
  		EmailVo emailVo = new EmailVo();
		int result = 0;
		if(password != null || !"".equals(password)) {
			randomPwd = StringUtil.randowPwdInit(10);
			member.setPassword(randomPwd);
			//임시 비밀번호로 업데이트 침
			result = dao.initPwd(member);
			if(result > 0 ) {
				emailVo.setContent("비밀번호는 "+randomPwd+"입니다");
				emailVo.setReceiver(member.getEmail());
			    emailVo.setSubject(""+member.getId()+"님 비밀번호 찾기 메일 안내입니다");
			   
			    try {
			        MimeMessage message = mailSender.createMimeMessage();
			        MimeMessageHelper messageHelper= new MimeMessageHelper(message, true, "UTF-8");
			   
			        messageHelper.setFrom("gajago84@gmail.com");  // 보내는사람 생략하거나 하면 정상작동을 안함
			        messageHelper.setTo(emailVo.getReceiver());     // 받는사람 이메일
			        messageHelper.setSubject(emailVo.getSubject()); // 메일제목은 생략이 가능하다
			        messageHelper.setText(emailVo.getContent());  // 메일 내용
 			        mailSender.send(message);
			      } catch(Exception e){
			        System.out.println(e);
			      }
	 		    
			}
		}
 		return result;
	}
}
