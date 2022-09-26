package com.thales.devtest.repository.model;

import com.thales.devtest.domain.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseForList implements Serializable {

    private String status;

    private List<Employee> data;

    private String message;
}
