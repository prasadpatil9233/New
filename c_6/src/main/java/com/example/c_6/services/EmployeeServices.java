package com.example.c_6.services;

import com.example.c_6.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeServices
{
//    public Employee add(Employee employee);
    public Employee add(Employee employee);
    public List<Employee> get();
    public Optional<Employee> getById(int id);
    public void deleteById(int id);
    public  Employee updateById(int id,Employee employeeDetails);

    public List<Employee> getAllEmployeesSortedByAgeAscending();
    public List<Employee> getAllEmployeesSortedByAgeDescending();
    List<Employee> getEmployeesWithIdGreaterThan(int id);

}
