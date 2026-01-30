package com.example.test;

import org.springframework.stereotype.Component;

@Component("email")
public class EmailNotification implements NotificationService{

	@Override
	public void send(String message) {
		 System.out.println("Sending Email: " + message);
	}

}
