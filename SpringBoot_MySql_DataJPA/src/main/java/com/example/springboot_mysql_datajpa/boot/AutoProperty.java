package com.example.springboot_mysql_datajpa.boot;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@PropertySource("classpath:my-application.properties")
@Data
public class AutoProperty {

    @Value("${my.number}")
    private Integer name;

    @Value("${my.uuid}")
    private UUID number;
}
