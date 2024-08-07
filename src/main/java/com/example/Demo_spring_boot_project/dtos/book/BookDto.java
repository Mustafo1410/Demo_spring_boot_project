package com.example.Demo_spring_boot_project.dtos.book;

import com.example.Demo_spring_boot_project.dtos.school.SchoolDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "comment is not null")
    private String comment;
    private String name;

    private Double price;
    private Integer page;
    private boolean delete;

    //private SchoolDto schoolDto;
    //private Integer authorId;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
