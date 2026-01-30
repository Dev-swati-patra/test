package com.example.test;

import org.springframework.stereotype.Component;

@Component("sms")
public class SMSNotification implements NotificationService{

	@Override
	public void send(String message) {
		 System.out.println("Sending SMS: " + message);
	}

}
