package com.taeyoung.comet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.taeyoung.comet"})
public class Oauth2WithJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2WithJwtApplication.class, args);
    }

}
