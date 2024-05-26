package com.example.Demo_spring_boot_project.dtos.author;

import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {
    public Author toAuthor(AuthorDto authorDto) {

        return Author.builder()
                .id(authorDto.getId())
                .surname(authorDto.getSurname())
                .name(authorDto.getName())
                .age(authorDto.getAge())
                .books(authorDto.getBooks())
                .updatedAt(authorDto.getUpdatedAt())
                .deletedAt(authorDto.getDeletedAt())
                .createdAt(authorDto.getCreatedAt())
                .build();
    }

    public AuthorDto toAuthorDto(Author author) {
        return AuthorDto.builder()
                .id(author.getId())
                .surname(author.getSurname())
                .name(author.getName())
                .age(author.getAge())
                .books(author.getBooks())
                .updatedAt(author.getUpdatedAt())
                .deletedAt(author.getDeletedAt())
                .createdAt(author.getCreatedAt())
                .build();
    }

    public void updateAuthor(AuthorDto authorDto, Author author) {
        if (authorDto == null)
            return;
        if (authorDto.getId() != null)
            author.setId(authorDto.getId());
        if (authorDto.getSurname() != null)
            author.setSurname(authorDto.getSurname());
        if (authorDto.getName() != null)
            author.setName(authorDto.getName());
        if (authorDto.getAge() != null)
            author.setAge(authorDto.getAge());
    }


}
