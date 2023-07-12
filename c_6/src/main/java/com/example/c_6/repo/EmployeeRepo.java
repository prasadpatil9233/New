package com.example.c_6.repo;

import com.example.c_6.entity.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee,Integer>
{
    List<Employee> findAll(Sort sort);
    @Query("SELECT e FROM Employee e WHERE e.id > :id")
    List<Employee> findEmployeesByIdGreaterThan(@Param("id") int id);

}
