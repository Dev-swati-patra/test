package com.example.test;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class NotificationHandler {

	// if we use if-else instead of map
//	 private final EmailNotification emailNotification;
//	    private final SMSNotification smsNotification;
//
//	    @Autowired
//	    public NotificationHandler(EmailNotification emailNotification, SMSNotification smsNotification) {
//	        this.emailNotification = emailNotification;
//	        this.smsNotification = smsNotification;
//	    }
//
//	    public void notify(String type, String message) {
//	        if ("email".equalsIgnoreCase(type)) {
//	            emailNotification.send(message);
//	        } else if ("sms".equalsIgnoreCase(type)) {
//	            smsNotification.send(message);
//	        } else {
//	            System.out.println("Unknown notification type: " + type);
//	        }
//	    }

	private final Map<String, NotificationService> dmap;
	
	// Spring injects all beans implementing NotificationService into this map
	public NotificationHandler(Map<String, NotificationService> map) {
		this.dmap = map;
	}

	public void notify(String type, String msg) {
		NotificationService notificationService = dmap.get(type);
		if (notificationService != null) {
			notificationService.send(msg);
		} else {
			System.out.println("No such notification type: " + type);
		}
	}

}
