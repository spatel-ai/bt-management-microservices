package com.bt.management.microservices.authenticationservice.config;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Data
@Validated
@ConfigurationProperties(prefix = "user")
public class UserConfiguration {
    @NotBlank(message = "name is blank")
    private String name;

    @NotBlank(message = "email is blank")
    private String email;

    @NotBlank(message = "password is blank")
    private String password;

    @Valid
    @NotNull(message = "address is null")
    private AddressConfig address;

    @Data
    public static class AddressConfig {
        @NotBlank(message = "City is Blank")
        private String city;

        @NotBlank(message = "State is Blank")
        private String state;

        @NotBlank(message = "pincode is Blank")
        private String pincode;

        @NotEmpty(message = "Contacts is Empty")
        private List<@NotBlank String> contacts;
    }

}
