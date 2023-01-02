package com.employee.EmployeeApplication.service;
import java.util.*;

import com.employee.EmployeeApplication.entity.Employee;
import com.employee.EmployeeApplication.repository.EmployeeRepository;


import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        // TODO Auto-generated method stub
        return employeeRepository.findAll();
    }

    public void saveEmployee(Employee employee) {
        // TODO Auto-generated method stub
        this.employeeRepository.save(employee);

    }

    public Employee getEmployeeById(int id) {
        // TODO Auto-generated method stub
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException("Employee not found by id: " + id);
        }
        return employee;
    }

    public void deleteEmployeeById(int id) {
        // TODO Auto-generated method stub
        this.employeeRepository.deleteById(id);
    }

    public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        // TODO Auto-generated method stub
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
                : Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.employeeRepository.findAll(pageable);
    }

}