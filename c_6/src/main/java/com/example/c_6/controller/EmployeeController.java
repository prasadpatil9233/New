package com.example.c_6.controller;

import com.example.c_6.entity.Employee;
import com.example.c_6.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController
{
    @Autowired
    private EmployeeServices employeeServices;
    @PostMapping("/all")
    public Employee add( @RequestBody Employee employee)
    {
        return employeeServices.add(employee);
    }

    @GetMapping("/all")
    public List<Employee> get()
    {
        return employeeServices.get();
    }

//    @GetMapping("/all/{id}")
//    public Employee getById(@PathVariable int id)
//    {
//        return employeeServices.getById(id);
//    }
//    @GetMapping("/all/{id}")
//    public ResponseEntity<Optional<Employee>> getById(int id)
//    {
//        Optional<Employee> employee = employeeServices.getById(id);
//
//        if(employee.isPresent())
//        {
//            return new ResponseEntity<>(employee, HttpStatus.OK);
//        }
//        else
//        {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @GetMapping("/all/{id}")
    public ResponseEntity<Optional<Employee>> findById(@PathVariable int id)
    {
        Optional<Employee> optionalEmployee = employeeServices.getById(id);
        if (optionalEmployee.isPresent())
        {
            return new ResponseEntity<>(optionalEmployee,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @DeleteMapping("/all/id/{id}")
//    public String deleteById( @PathVariable int id)
//    {
//        employeeServices.deleteById(id);
//        return "Deleted";
//    }

    @DeleteMapping("/all/id/{id}")
    public String deleteByid(@PathVariable int id)
    {
        Optional<Employee> optionalEmployee =employeeServices.getById(id);
        if(optionalEmployee.isPresent())
        {
            employeeServices.deleteById(id);
            return "Deleted";
        }
        else
        {
            return "Not Preasent";
        }
    }

    @PutMapping("/all/{id}")
    public  String updateById(@PathVariable int id,@RequestBody Employee employee)
    {
        Optional<Employee> optionalEmployee = employeeServices.getById(id);
        if (optionalEmployee.isPresent())
        {
            employeeServices.updateById(id,employee);
            return "Updated";
        }
        else
        {
            return "Not found";
        }
    }

    @GetMapping("/sorted-by-age-asc")
    public ResponseEntity<List<Employee>> getAllEmployeesSortedByAgeAscending() {
        List<Employee> employees = employeeServices.getAllEmployeesSortedByAgeAscending();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/sorted-by-age-desc")
    public ResponseEntity<List<Employee>> getAllEmployeesSortedByAgeDescending() {
        List<Employee> employees = employeeServices.getAllEmployeesSortedByAgeDescending();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/id-greater-than/{id}")
    public ResponseEntity<List<Employee>> getEmployeesWithIdGreaterThan(@PathVariable("id") int id) {
        List<Employee> employees = employeeServices.getEmployeesWithIdGreaterThan(id);
        return ResponseEntity.ok(employees);
    }

}
