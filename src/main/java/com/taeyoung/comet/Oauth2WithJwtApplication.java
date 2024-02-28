package com.taeyoung.comet;

import com.taeyoung.comet.repository.RefreshTokenRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.taeyoung.comet"})
@EnableJpaRepositories(basePackages = "com.taeyoung.comet", excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {RefreshTokenRepository.class}))
public class Oauth2WithJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2WithJwtApplication.class, args);
    }

}
