package com.example.springboot_mysql_datajpa.boot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class AutoPropertyTest {

    @Autowired
    AutoProperty autoProperty;

    @Test
    void getRandom(){
        log.info(autoProperty.toString());
    }

}