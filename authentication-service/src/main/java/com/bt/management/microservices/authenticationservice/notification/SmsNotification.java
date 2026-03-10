package com.bt.management.microservices.authenticationservice.notification;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@NotifyChannel(NotifyTypes.SMS)
public class SmsNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println(message + " Sms Notification are sent !");
    }
}
