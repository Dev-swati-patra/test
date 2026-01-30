package com.example.test;

import org.springframework.stereotype.Component;

@Component("push")
public class PushNotification implements NotificationService{

	@Override
	public void send(String message) {
		 System.out.println("Sending Push notification: " + message);
	}

}
