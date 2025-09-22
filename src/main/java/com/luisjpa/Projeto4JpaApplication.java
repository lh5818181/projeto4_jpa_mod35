package com.luisjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.luisjpa.domain")
@EnableJpaRepositories(basePackages = "com.luisjpa.repository")
public class Projeto4JpaApplication {
    public static void main(String[] args) {
        SpringApplication.run(Projeto4JpaApplication.class, args);
    }
}