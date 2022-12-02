package com.example.springboot_mysql_datajpa.repository;

import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@NoArgsConstructor
public class EmployeeMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setIdEmployee(resultSet.getLong("idemployee"));
        employee.setName(resultSet.getString("name"));
        employee.setBirthday(resultSet.getInt("birthday"));
        return employee;
    }
}
