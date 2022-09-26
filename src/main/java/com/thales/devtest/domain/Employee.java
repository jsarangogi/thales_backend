package com.thales.devtest.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Employee implements Serializable {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("employee_name")
    private String name;

    @JsonProperty("employee_salary")
    private int salary;

    private int anualSalary;

    @JsonProperty("employee_age")
    private int age;

    @JsonProperty("profile_image")
    private String profileImage;

}
