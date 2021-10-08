package com.carrie.lu.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class Config {

    @Value("${spring.application.name}")
    private String applicationName;

    public void checkConfig() {
        System.out.println(applicationName);
    }

}
