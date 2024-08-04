package com.example.Demo_spring_boot_project.dtos.exception;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ErrorDto {
    private String message;
    private String code;
    private String field;
}
