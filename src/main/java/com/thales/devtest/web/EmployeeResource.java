package com.thales.devtest.web;

import com.thales.devtest.domain.Employee;
import com.thales.devtest.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/")
@CrossOrigin(origins = "http://localhost:8181")
public class EmployeeResource {

    private final EmployeeService employeeService;

    @GetMapping("employees")
    public ResponseEntity listAllEmployees() {
        try {
            final List<Employee> employees = employeeService.listAllEmployees();
            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("employee/{id}")
    public ResponseEntity getEmployeeById(@PathVariable("id") Long id) {
        try {
            final Employee employee = employeeService.getEmployeeById(id);
            return new ResponseEntity<>(Arrays.asList(employee), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
