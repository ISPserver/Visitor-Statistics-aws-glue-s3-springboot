package com.example.visitorstatistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.example.visitorstatistics"})
@EnableJpaRepositories(basePackages = {"com.example.visitorstatistics"})
@SpringBootApplication(scanBasePackages = {"com.example"})
public class VisitorStatisticsApplication {

    public static void main(String[] args) {
        SpringApplication.run(VisitorStatisticsApplication.class, args);
    }

}
