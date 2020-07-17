package com.ats.rusaaccessapi.RusaAccessWebapi.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.ats.rusaaccessapi.RusaAccessWebapi.model.Info;

public class Test {
	static String senderEmail ="techrusa1@gmail.com";
	static String senderPassword ="@Rusamah";// "atsinfosoft@123";
	static String mailsubject = " RUSA Software Login Credentials ";

	public static Info sendEmail( ) {
			
			Info info=new Info();
			
			try {
				
			final String emailSMTPserver = "smtp.gmail.com";
			final String emailSMTPPort = "587";
			final String mailStoreType = "imaps";
			final String username = senderEmail;//"atsinfosoft@gmail.com";
			final String password =senderPassword;//"atsinfosoft@123";

			System.out.println("username" + username);
			System.out.println("password" + password);

			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.starttls.enable", "true");


			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});

			try {
				Store mailStore = session.getStore(mailStoreType);
				mailStore.connect(emailSMTPserver, username, password);

				String address ="handgesachin1@gmail.com";// "atsinfosoft@gmail.com";// address of to

				String subject = mailsubject;//" Login Credentials For RUSA Login  ";

				Message mimeMessage = new MimeMessage(session);
				mimeMessage.setFrom(new InternetAddress(username));
				mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(address));
				mimeMessage.setSubject(subject);
				mimeMessage.setText("User Registration Successful for RUSA Software \n Username: " + "JJJJ" + "\n Password: " + "KKKK");
				
			
				Transport.send(mimeMessage);
			} catch (Exception e) {
				e.printStackTrace();
				info.setError(true);
				info.setMessage("email_exce");
			}
				
				info.setError(false);
				info.setMessage("success_email");
			}catch (Exception e) {
				
				info.setError(true);
				info.setMessage("email_exce");
			}
			
			return info;
			
		}
	public static void main(String[] args) {
		sendEmail( );
	}
}
