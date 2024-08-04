package com.example.Demo_spring_boot_project.dtos.author;

import com.example.Demo_spring_boot_project.dtos.book.Book;
import com.example.Demo_spring_boot_project.dtos.book.BookDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthorDto {
    private Integer id;
    private String surname;
    private String name;
    private Integer age;
    //private Integer books;

    //private Set<BookDto> books;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
