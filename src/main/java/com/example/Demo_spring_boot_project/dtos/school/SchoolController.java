package com.example.Demo_spring_boot_project.dtos.school;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import io.swagger.v3.oas.models.annotations.OpenAPI31;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/school/")
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService schoolService;

    @PostMapping("/create")
    @Operation(description = "CREATE SCHOOL METHOD",method = "@POST_MAPPING")
    public ResponseEntity<SchoolDto> createSchool(@RequestBody @Valid SchoolDto dto) {
        return this.schoolService.create(dto);
    }

    @GetMapping("/get")
    public ResponseEntity<SchoolDto> get(@RequestParam("id") Integer id) {
        return this.schoolService.get(id);
    }

    @PutMapping("/update")
    public ResponseEntity<SchoolDto> update(@RequestParam("id") Integer id, @RequestBody SchoolDto dto) {
        return this.schoolService.update(dto, id);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<SchoolDto>> getAll() {
        return this.schoolService.getAll();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<SchoolDto> delete(@RequestParam("id") Integer id) {
        return this.schoolService.delete(id);
    }

    @GetMapping("/selectCAINN_1")
    public ResponseEntity<SchoolDto> selectCAINN_1() {
        return this.schoolService.getByCreatedAtISNotNull();
    }
}
