package com.example.Demo_spring_boot_project.dtos.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private SchoolMapper schoolMapper;

    @Override
    public ResponseEntity<SchoolDto> create(SchoolDto dto) {
        School school = this.schoolMapper.toEntity(dto);
        school.setCreateAt(LocalDateTime.now());
        this.schoolRepository.save(school);
        return ResponseEntity.ok(this.schoolMapper.toDto(school));
    }

    @Override
    public ResponseEntity<SchoolDto> get(Integer id) {
        School school = this.schoolRepository.findById(id)
                .orElse(new School());
        SchoolDto dto = this.schoolMapper.toDto(school);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<SchoolDto> update(SchoolDto dto, Integer id) {
        School school = this.schoolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("School not found"));
        this.schoolMapper.update(school, dto);
        school.setUpdateAt(LocalDateTime.now());
        this.schoolRepository.save(school);
        return ResponseEntity.ok(this.schoolMapper.toDto(school));
    }

    @Override
    public ResponseEntity<SchoolDto> delete(Integer id) {
        School school = this.schoolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("School not found"));
        school.setDeleteAt(LocalDateTime.now());
        this.schoolRepository.save(school);
        SchoolDto dto = this.schoolMapper.toDto(school);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<List<SchoolDto>> getAll() {
        List<School> all = this.schoolRepository.findAll();
        List<SchoolDto> schoolDto = this.schoolMapper.dtoList(all);
        return ResponseEntity.ok(schoolDto);
    }

    @Override
    public ResponseEntity<SchoolDto> getByCreatedAtISNotNull() {
        School school = this.schoolRepository.selectSchoolCreatedAtIsNotNull();
        SchoolDto dto = this.schoolMapper.toDto(school);
        return ResponseEntity.ok(dto);
    }
}
