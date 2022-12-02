package com.example.springboot_mysql_datajpa.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    private final String SQL_FIND_EMPLOYEE = "select * from employee";

    private final JdbcTemplate jdbcTemplate;

    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Employee> getData(){
       return this.jdbcTemplate.query(SQL_FIND_EMPLOYEE, new EmployeeMapper());
    }
}
