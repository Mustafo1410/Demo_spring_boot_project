package com.example.Demo_spring_boot_project.dtos.school;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SchoolService {
    ResponseEntity<SchoolDto> create(SchoolDto dto);

    ResponseEntity<SchoolDto> get(Integer id);

    ResponseEntity<SchoolDto> update(SchoolDto dto, Integer id);

    ResponseEntity<SchoolDto> delete(Integer id);

    ResponseEntity<List<SchoolDto>> getAll();

    ResponseEntity<SchoolDto> getByCreatedAtISNotNull();
}
