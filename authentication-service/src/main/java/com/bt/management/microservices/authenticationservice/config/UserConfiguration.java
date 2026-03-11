package com.bt.management.microservices.authenticationservice.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Data
@Validated
@ConfigurationProperties(prefix = "user")
public class UserConfiguration {
    private String name;

    private String email;

    private String password;

    private AddressConfig address;

    @Data
    public static class AddressConfig {
        private String city;

        private String state;

        private String pincode;

        private List<String> contacts;
    }

}
