package com.example.Demo_spring_boot_project.dtos.book;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDto {
    private Integer id;
    @Column(length = 20,nullable = false)
    private String comment;
    private String name;
    @Column(updatable = false)
    private Double price;
    private Integer page;
    private boolean delete;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
