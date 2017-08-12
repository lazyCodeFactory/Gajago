package com.Gajago.com.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class GoogleAuthentication extends Authenticator {
	PasswordAuthentication pa;
	  
    public GoogleAuthentication(){  //생성자를 통해 구글 ID/PW 인증
          
        String id = "구글 mail ID";       // 구글 ID
        String pw = "비밀번호";          // 구글 비밀번호
  
        // ID와 비밀번호를 입력한다.
        pa = new PasswordAuthentication(id, pw);
    }
  
    // 시스템에서 사용하는 인증정보
    @Override
	public PasswordAuthentication getPasswordAuthentication() {
        return pa;
    }


 }
