package com.bt.management.microservices.authenticationservice.notification;

import org.springframework.stereotype.Component;
import com.bt.management.microservices.authenticationservice.helpers.EmailChannel;

@Component
@EmailChannel
public class EmailNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println(message + " Email Notification are sent !");
    }

}
