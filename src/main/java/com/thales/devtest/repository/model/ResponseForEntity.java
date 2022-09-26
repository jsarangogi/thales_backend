package com.thales.devtest.repository.model;

import com.thales.devtest.domain.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseForEntity implements Serializable {

    private String status;

    private Employee data;

    private String message;
}
