package com.example.Demo_spring_boot_project.dtos.author;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceSimple implements AuthorServics<Integer, AuthorDto> {
    private final AuthorMapper authorMapper;
    List<Author> authorList = new ArrayList<>();
    Integer authorId = 1;

    @Override
    public AuthorDto create(AuthorDto dto) {
        Author author = this.authorMapper.toAuthor(dto);
        author.setId(authorId);
        author.setCreatedAt(LocalDateTime.now());
        this.authorList.add(author);
        authorId++;

        return this.authorMapper.toAuthorDto(author);
    }

    @Override
    public AuthorDto update(AuthorDto dto, Integer id) {
        for (Author author : authorList) {
            if (author.getId().equals(id)) {
                author.setUpdatedAt(LocalDateTime.now());

                this.authorMapper.updateAuthor(dto, author);
                return this.authorMapper.toAuthorDto(author);
            }

        }
        return null;
    }

    @Override
    public AuthorDto delete(Integer id) {
        return null;
    }


    @Override
    public AuthorDto get(Integer id) {
        return null;
    }

    @Override
    public List<AuthorDto> getAll() {
        return List.of();
    }
}
