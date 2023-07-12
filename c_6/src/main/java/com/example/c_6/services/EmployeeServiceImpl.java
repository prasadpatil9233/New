package com.example.c_6.services;

import com.example.c_6.entity.Employee;
import com.example.c_6.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeServices
{
    @Autowired
    private EmployeeRepo employeeRepo;

//    @Override
//    public Employee add(Employee employee) {
//        return employeeRepo.save(employee);
//    }


    @Override
    public Employee add(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> get() {
        return employeeRepo.findAll();
    }

    @Override
    public Optional<Employee> getById(int id) {
        return employeeRepo.findById(id);
    }

    @Override
    public void deleteById(int id)
    {
         employeeRepo.deleteById(id);

    }

    @Override
    public Employee updateById(int id,Employee employeeDetails)
    {
              Employee employee = employeeRepo.findById(id).get();
              employee.setName(employeeDetails.getName());
              employee.setLastname(employeeDetails.getLastname());
              employee.setEmail(employeeDetails.getEmail());
              return employeeRepo.save(employee);

    }

    public List<Employee> getAllEmployeesSortedByAgeAscending() {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        return employeeRepo.findAll(sort);
    }

    public List<Employee> getAllEmployeesSortedByAgeDescending() {
        Sort sort = Sort.by(Sort.Direction.DESC, "name");
        return employeeRepo.findAll(sort);
    }

    public List<Employee> getEmployeesWithIdGreaterThan(int id) {
        return employeeRepo.findEmployeesByIdGreaterThan(id);
    }


}
