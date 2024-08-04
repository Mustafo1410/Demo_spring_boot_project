package com.example.Demo_spring_boot_project.dtos.school;

import com.example.Demo_spring_boot_project.dtos.book.BookDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SchoolDto {
    private Integer id;

    @NotBlank(message = "name is required")
    private String name;
    @NotNull(message = "pupils is required")
    private Integer pupils;

    //private BookDto bookDto;



    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
