package com.hackfac.controllers.cnfg;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MailConfig {
	private static final Logger log = LoggerFactory.getLogger(MailConfig.class);
	public void sendMail() {
		final String username = "banerjeeindranil854@gmail.com";
		final String pd = "give your password";
		String userId="715013";
		String status="N";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, pd);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from-banerjeeindranil854@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("to-debalinalayek2018@gmail.com"));
			if(status.equals("N")) {
			message.setSubject("PLEASE SEND THE RESPONSE");
			message.setText("Dear Sir,"
				+ "\n\n PLEASE SEND THE RESPONSE");
			}
			else {
				message.setSubject("THANKS FOR SENDING THE RESPONSE");
				message.setText("Dear Sir,"
					+ "\n\n THANKS FOR SENDING THE RESPONSE");
			}
			Transport.send(message);
			log.info("------------------mail_send_successfull-----------------");
		} catch (MessagingException e) {
			log.error(e.getMessage());
		}
	}
}
