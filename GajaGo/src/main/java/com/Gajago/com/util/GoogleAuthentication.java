package com.Gajago.com.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class GoogleAuthentication extends Authenticator {
	PasswordAuthentication pa;
	  
    public GoogleAuthentication(){  //�����ڸ� ���� ���� ID/PW ����
          
        String id = "���� mail ID";       // ���� ID
        String pw = "��й�ȣ";          // ���� ��й�ȣ
  
        // ID�� ��й�ȣ�� �Է��Ѵ�.
        pa = new PasswordAuthentication(id, pw);
    }
  
    // �ý��ۿ��� ����ϴ� ��������
    @Override
	public PasswordAuthentication getPasswordAuthentication() {
        return pa;
    }


 }
