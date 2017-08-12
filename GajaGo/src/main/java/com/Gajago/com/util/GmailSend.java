package com.Gajago.com.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
 
public class GmailSend{
//�������� ������.
     
    //action
    public void GmailSet(String user, String text, String content) throws UnsupportedEncodingException{
        Properties p = System.getProperties();
        p.put("mail.smtp.starttls.enable", "true");    
        p.put("mail.smtp.host", "smtp.gmail.com");      // smtp ���� ȣ��Ʈ
        p.put("mail.smtp.auth","true");
        p.put("mail.smtp.port", "587");                 // gmail ��Ʈ
            
        Authenticator auth = new GoogleAuthentication();    //���� ���� ����
          
        //session ���� ��  MimeMessage����
        Session session = Session.getDefaultInstance(p, auth);
        MimeMessage msg = new MimeMessage(session);
        String fromName = "�߽��� �г���";
        String charSet = "UTF-8";
         
        try{
            // ���������ð� ����
            msg.setSentDate(new Date());
              String send ="<gajago84@gmail.com>";
            // �۽��� ����
            InternetAddress from = new InternetAddress() ;
            from = new InternetAddress(send,"UTF-8");
            msg.setFrom(from);
              
            // ������ ����
            InternetAddress to = new InternetAddress(user);
            msg.setRecipient(Message.RecipientType.TO, to);
             
            // ���� ����
            msg.setSubject(text, "UTF-8");
             
            msg.setText(content, "UTF-8");  //���� ����
             
            // ���� �۽�
            Transport.send(msg);   
             
            System.out.println("���� �߼��� �Ϸ��Ͽ����ϴ�.");
        }catch (AddressException addr_e) {  //����ó�� �ּҸ� �Է����� ���� ���
            JOptionPane.showMessageDialog(null, "������ �Է����ּ���", "�����ּ��Է�", JOptionPane.ERROR_MESSAGE);
            addr_e.printStackTrace();
        }catch (MessagingException msg_e) { //�޽����� �̻��� ���� ���
            JOptionPane.showMessageDialog(null, "������ ����� �Է����ּ���.", "�����߻�", JOptionPane.ERROR_MESSAGE);
            msg_e.printStackTrace();
        }
    }
}


