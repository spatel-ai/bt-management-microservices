package com.bt.management.microservices.authenticationservice.notification;

import org.springframework.stereotype.Component;

@Component
@NotifyChannel(value = NotifyTypes.EMAIL)
public class EmailNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println(message + " Email Notification are sent !");
    }

}
