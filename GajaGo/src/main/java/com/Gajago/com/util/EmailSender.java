package com.Gajago.com.util;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.Gajago.com.vo.EmailVo;

public class EmailSender {
    JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

	public void sendEMail(EmailVo email) {
		MimeMessage msg = javaMailSender.createMimeMessage();
		try {
			msg.setSubject(email.getSubject());
			msg.setText(email.getContent());
			msg.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(email.getReceiver()));
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		try {
			javaMailSender.send(msg);

		} catch (MailException ex) {
			ex.printStackTrace();
		}
	}

}
