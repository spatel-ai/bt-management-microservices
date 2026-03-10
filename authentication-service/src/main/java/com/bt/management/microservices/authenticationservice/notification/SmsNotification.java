package com.bt.management.microservices.authenticationservice.notification;

import org.springframework.stereotype.Component;

import com.bt.management.microservices.authenticationservice.helpers.SmsChannel;

@Component
@SmsChannel
public class SmsNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println(message + " Sms Notification are sent !");
    }
}
