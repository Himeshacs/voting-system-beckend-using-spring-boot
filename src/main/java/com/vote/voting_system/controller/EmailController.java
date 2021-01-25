package com.vote.voting_system.controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vote.voting_system.utill.AppDateTimeUtill;

@RestController
public class EmailController {
	 	
	@RequestMapping(value = "/sendemail")
	   public String sendEmail() {
				try {
					String From="";
					String Subject="SUBJECT";
					String Content="CONTENTTTT";
					String messageBody="BODYYYYYYYYYYYYYYYYYYYYY";
					String To="";
					sendmail(From,Subject,Content,messageBody,To);
				} catch (AddressException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	      return "Email sent successfully";
	   }

//	private void sendmail() throws AddressException, MessagingException, IOException {
//		   Properties props = new Properties();
//		   props.put("mail.smtp.auth", "true");
//		   props.put("mail.smtp.starttls.enable", "true");
//		   props.put("mail.smtp.host", "smtp.gmail.com");
//		   props.put("mail.smtp.port", "587");
//		   
//		   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
//		      protected PasswordAuthentication getPasswordAuthentication() {
//		         return new PasswordAuthentication("thilina2u@gmail.com", "qkmwjirzjqnkymkv");
//		      }
//		   });
//		   Message msg = new MimeMessage(session);
//		   msg.setFrom(new InternetAddress("thilina2u@gmail.com", false));
//
//		   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("thilina2u@gmail.com"));
//		   msg.setSubject("Tutorials point email");
//		   msg.setContent("Tutorials point email", "text/html");
//		   msg.setSentDate(AppDateTimeUtill.getCurrentDateTime());
//
//		   MimeBodyPart messageBodyPart = new MimeBodyPart();
//		   messageBodyPart.setContent("Tutorials point email", "text/html");
//
//		   Multipart multipart = new MimeMultipart();
//		   multipart.addBodyPart(messageBodyPart);
////		   MimeBodyPart attachPart = new MimeBodyPart();
//
////		   attachPart.attachFile("/var/tmp/image19.png");
////		   multipart.addBodyPart(attachPart);
//		   msg.setContent(multipart);
//		   Transport.send(msg);
//		   System.out.println("mail sent"+);
//		}
	
	public void sendmail(String From,String Subject,String Content,String messageBody,String To) throws AddressException, MessagingException, IOException {
		   Properties props = new Properties();
		   props.put("mail.smtp.auth", "true");
		   props.put("mail.smtp.starttls.enable", "true");
		   props.put("mail.smtp.host", "smtp.gmail.com");
		   props.put("mail.smtp.port", "587");
		   
		   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		      protected PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication("election.department2020@gmail.com", "hkqknhswjpcegenc");
		      }
		   });
		   Message msg = new MimeMessage(session);
		   msg.setFrom(new InternetAddress("election.department2020@gmail.com", false));

		   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(To));
		   msg.setSubject(Subject);
		   msg.setContent(Content, "text/html");
		   msg.setSentDate(AppDateTimeUtill.getCurrentDateTime());

		   MimeBodyPart messageBodyPart = new MimeBodyPart();
		   messageBodyPart.setContent(messageBody, "text/html");

		   Multipart multipart = new MimeMultipart();
		   multipart.addBodyPart(messageBodyPart);
//		   MimeBodyPart attachPart = new MimeBodyPart();

//		   attachPart.attachFile("/var/tmp/image19.png");
//		   multipart.addBodyPart(attachPart);
		   msg.setContent(multipart);
		   Transport.send(msg);
		   System.out.println("mail sent---->>"+To);
		}
	
}
