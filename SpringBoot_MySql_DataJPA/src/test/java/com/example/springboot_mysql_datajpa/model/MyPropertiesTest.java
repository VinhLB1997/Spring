package com.example.springboot_mysql_datajpa.model;

import com.example.springboot_mysql_datajpa.boot.AutoProperty;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class MyPropertiesTest {
    @Autowired
    MyProperties myProperties;

    @Test
    void getProperty() {
        log.info(myProperties.toString());
//        log.info("Size: " + myProperties.getSecurity().getRoles().size());
    }
}