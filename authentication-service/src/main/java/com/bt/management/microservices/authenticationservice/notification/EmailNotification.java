package com.bt.management.microservices.authenticationservice.notification;

import org.springframework.stereotype.Component;
import com.bt.management.microservices.authenticationservice.helpers.NotifyChannel;
import com.bt.management.microservices.authenticationservice.helpers.NotifyTypes;

import lombok.extern.slf4j.Slf4j;

@Component
@NotifyChannel(value = NotifyTypes.EMAIL)
@Slf4j
public class EmailNotification implements Notification {

    @Override
    public void send(String message) {
        log.info("{} Email Notification are sent !", message);
    }

}
