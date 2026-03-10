package com.bt.management.microservices.authenticationservice.notification;

import org.springframework.stereotype.Component;

import com.bt.management.microservices.authenticationservice.helpers.PushChannel;

@Component
@PushChannel
public class PushNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println(message + " Push Notification are sent !");
    }

}
