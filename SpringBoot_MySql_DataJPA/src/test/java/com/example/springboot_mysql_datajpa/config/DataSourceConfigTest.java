package com.example.springboot_mysql_datajpa.config;

import com.example.springboot_mysql_datajpa.repository.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
@Slf4j
class DataSourceConfigTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    ApplicationContext applicationContext;

    @Test
    void dataSource() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            log.info("catalog:" + connection.getCatalog());
            log.info("catalog:" + connection.toString());
        }
    }

    @Test
    void testBean() {

    }

    @Test
    void newEmployee() {
        Employee employee = applicationContext.getBean("newEmployee", Employee.class);
        log.info(employee.toString());
    }
}