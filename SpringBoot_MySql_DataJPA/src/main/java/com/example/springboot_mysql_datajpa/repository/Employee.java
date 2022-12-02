package com.example.springboot_mysql_datajpa.repository;

import lombok.Data;

@Data
public class Employee {
    private Long idEmployee;
    private String name;
    private Integer birthday;
}
