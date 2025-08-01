package com.jimmyproject.utils;

import com.jimmyproject.utils.jwt.JwtProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(JwtProperties.class)
public class CommonlibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonlibraryApplication.class, args);
    }

}
