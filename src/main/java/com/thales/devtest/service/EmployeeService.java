package com.thales.devtest.service;

import com.thales.devtest.domain.Employee;
import com.thales.devtest.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> listAllEmployees() throws Exception {
        return employeeRepository.retrieveAllEmployees()
                .parallelStream()
                .peek(this::calculateAnualSalary)
                .collect(Collectors.toList());
    }

    public Employee getEmployeeById(final Long id) throws Exception {
        return employeeRepository.retrieveEmployeeById(id)
                .map(e -> { this.calculateAnualSalary(e); return e; })
                .orElse(Employee.builder().id(id).name("-").build());
    }

    private void calculateAnualSalary(Employee employee) {
        employee.setAnualSalary(employee.getSalary() * 12);
    }
}
