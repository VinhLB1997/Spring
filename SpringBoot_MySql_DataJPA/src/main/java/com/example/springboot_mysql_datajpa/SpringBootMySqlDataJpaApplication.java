package com.example.springboot_mysql_datajpa;

import org.springframework.boot.Banner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootMySqlDataJpaApplication {

    @Bean
    public ExitCodeGenerator exitCodeGenerator() {
        return () -> 42;
    }


    public static void main(String[] args) {
//        SpringApplication.run(SpringBootMySqlDataJpaApplication.class, args);
        SpringApplication springApplication = new SpringApplication(SpringBootMySqlDataJpaApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.setApplicationStartup(new BufferingApplicationStartup(2048));
        springApplication.run(args);
    }

}
