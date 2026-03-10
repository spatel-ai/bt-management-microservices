package com.bt.management.microservices.authenticationservice.notification;

import org.springframework.stereotype.Component;

@Component
public class PushNotification implements Notification {

    @Override
    public void send() {
        System.out.println("Push Notification are sent !");
    }

}
