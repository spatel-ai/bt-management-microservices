package com.bt.management.microservices.authenticationservice.notification;

import org.springframework.stereotype.Component;

import com.bt.management.microservices.authenticationservice.helpers.NotifyChannel;
import com.bt.management.microservices.authenticationservice.helpers.NotifyTypes;

import lombok.extern.slf4j.Slf4j;

@Component
@NotifyChannel(value = NotifyTypes.SMS)
@Slf4j
public class SmsNotification implements Notification {
    
    @Override
    public void send(String message) {
        log.info("{} SMS Notification are sent !", message);
    }
}
