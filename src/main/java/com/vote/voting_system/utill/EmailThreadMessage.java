package com.vote.voting_system.utill;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.vote.voting_system.controller.EmailController;

public class EmailThreadMessage implements Runnable{

	List<String[]> emailSet= null;
	
	
	
	public EmailThreadMessage(List<String[]> emailSet) {
		super();
		this.emailSet = emailSet;
	}



	@Override
	public void run() {
		Iterator<String[]> itr= emailSet.iterator();
		while(itr.hasNext()){
			String ar[] = itr.next();
			EmailController emailController=new EmailController();
			String From="thilina2u@gmail.com";
//			emailController.sendmail(From, Subject, Content, messageBody, To);
			try {
//				System.out.println(ar[0]);
//				System.out.println(ar[1]);
//				System.out.println(ar[2]);
				emailController.sendmail(From, ar[0], ar[0], ar[2], ar[1]);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
	}

}
