package com.example.Demo_spring_boot_project.dtos.school;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School, Integer> {

    @Query(nativeQuery = true, value = "select * from school where create_at is not null limit 1")
    School selectSchoolCreatedAtIsNotNull();
}
