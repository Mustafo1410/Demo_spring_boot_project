package com.example.Demo_spring_boot_project.dtos.author;

import com.example.Demo_spring_boot_project.dtos.book.Book;
import com.example.Demo_spring_boot_project.dtos.book.BookDto;
import com.example.Demo_spring_boot_project.dtos.book.BookMapper;
import com.example.Demo_spring_boot_project.dtos.book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class AuthorServiceSimple implements AuthorServics<Integer, AuthorDto> {
    private final AuthorMapper authorMapper;
    List<Author> authorList = new ArrayList<>();
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    Integer authorId = 1;

    @Override
    public AuthorDto create(AuthorDto dto) {
        Author author = this.authorMapper.toAuthor(dto);
        author.setId(authorId);
        author.setCreatedAt(LocalDateTime.now());
        this.authorList.add(author);
        authorRepository.save(author);
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
        Author author = this.authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("AUTHOR IS NOT FOUND"));
        Set<Book> books = this.bookRepository.selectByAuthorId(id);
        Set<BookDto> bookDtos = books.stream().map(this.bookMapper::toBookDto).collect(Collectors.toSet());
        AuthorDto authorDto = this.authorMapper.authorDtoWithBooks(author);
        //authorDto.setBooks(bookDtos);

        return authorDto;
    }

    @Override
    public List<AuthorDto> getAll() {
        return authorList.stream().map(this.authorMapper::toAuthorDto).toList();
    }

    public AuthorDto getAuthor(Integer id) {
        Book book = this.bookRepository.findById(id).
                orElseThrow(() -> new RuntimeException("BOOK IS NOT FOUND"));
        //Integer authorId = book.getAuthorId();
        Author author = this.authorRepository.findById(authorId).orElseThrow(() -> new RuntimeException("AUTHOR IS NOT FOUND"));
        return this.authorMapper.toAuthorDto(author);
    }
}
