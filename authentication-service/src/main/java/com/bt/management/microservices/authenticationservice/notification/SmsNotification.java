package com.bt.management.microservices.authenticationservice.notification;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class SmsNotification implements Notification {
    @Override
    public void send() {
        System.out.println("Sms Notification are sent !");
    }
}
