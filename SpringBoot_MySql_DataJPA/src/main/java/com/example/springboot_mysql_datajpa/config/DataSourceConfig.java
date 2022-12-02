package com.example.springboot_mysql_datajpa.config;

import com.example.springboot_mysql_datajpa.repository.Employee;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:my-application.properties")
public class DataSourceConfig {

    @Bean
    DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setMaximumPoolSize(2);
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/mydb");
        config.setUsername("root");
        config.setPassword("20150601");
        return new HikariDataSource(config);
    }

    @Bean
    @ConfigurationProperties(prefix = "employee")
    Employee newEmployee(){
        return new Employee();
    }
}
