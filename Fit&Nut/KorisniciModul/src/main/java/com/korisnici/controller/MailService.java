package com.korisnici.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	private MailSender mailSender;
	@SuppressWarnings("unused")
	private SimpleMailMessage templateMessage;
	
	
    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setTemplateMessage(SimpleMailMessage templateMessage) {
        this.templateMessage = templateMessage;
    }
    
    public void sendMail(){
    	SimpleMailMessage msg= new SimpleMailMessage();
    	msg.setTo("atahic1@gmail.com");
    	msg.setText("Proba");
    	msg.setReplyTo("neodgovaraj@noreply.com");
    	msg.setFrom("neodgovaraj@noreply.com");
    	try {
    		mailSender.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    
    public void sendResetPasswordMail(String email,String password){
    	SimpleMailMessage msg=new SimpleMailMessage();
    	msg.setTo(email);
    	msg.setText(" Vaš novi password:" + password);
    	msg.setReplyTo("neodgovaraj@gmail.com");
    	msg.setFrom("neodgovaraj@noreply.com");
    	try{
    		mailSender.send(msg);
    	} catch (Exception e) {
			// TODO: handle exception
    		e.printStackTrace();
		}
    	
    }
}