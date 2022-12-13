package com.tradex.services;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Transport;
import java.util.ArrayList;
import java.util.Properties;

public class EmailNotification {
	private final String from = "mahavaccinationdrive1@gmail.com";
	private String subject;
 	private static ArrayList al;
	public Boolean sendOtpTomail(int num,String to)
	{
		Boolean b = true;
		subject = "Sign Up Confirmation";
		String host = "smtp.gmail.com";
		Properties p = System.getProperties();
		p.put("mail.smtp.host", host);
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.ssl.enable", "true");
		p.put("mail.smtp.auth", "true");
		Session s = Session.getInstance(p, new Authenticator()
				{

					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						// TODO Auto-generated method stub
						return new PasswordAuthentication(from,"fovwozzisrshnylr");
					}
			
				});
		MimeMessage m = new MimeMessage(s);
		try {
			m.setFrom(from);
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			m.setSubject(subject);
			m.setText("TradeX never calls for OTP.\nDo not share it with anyone.\nSign Up OTP : "+num);
			Transport.send(m);
		}
		catch(MessagingException e)
		{
			e.printStackTrace();
			b = false;
		}
		finally
		{
			System.out.println("Completed");
			
		}
		return b;
	}
}

