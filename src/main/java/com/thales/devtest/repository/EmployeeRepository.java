package com.thales.devtest.repository;

import com.thales.devtest.domain.Employee;
import com.thales.devtest.repository.model.ResponseForEntity;
import com.thales.devtest.repository.model.ResponseForList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class EmployeeRepository {
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${employee.api.base.url}")
    private String apiUrl;

    public List<Employee> retrieveAllEmployees() throws Exception {
        List<Employee> employees = new ArrayList<>();
        final URI uri = URI.create(String.join("", apiUrl, "/employees"));
        final ResponseForList response = performApiCall(uri, ResponseForList.class);
        return Objects.requireNonNull(response).getData();
    }

    public Optional<Employee> retrieveEmployeeById(final Long id) throws Exception {
        final URI uri = URI.create(String.join("", apiUrl, "/employee/", id.toString()));
        final ResponseForEntity response = performApiCall(uri, ResponseForEntity.class);
        return Optional.ofNullable(response.getData());
    }

    private <T> T performApiCall(final URI uri, final Class<T> responseClass) throws Exception {
        final ResponseEntity<T> response = restTemplate.getForEntity(uri, responseClass);
        if(response.getStatusCode().is2xxSuccessful())
            return response.getBody();
        else
            throw new Exception("Can't retrieve info from external api");
    }
}
