package com.example.Demo_spring_boot_project.dtos.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService<Integer, BookDto> {
    private final BookMapper bookMapper;
    List<Book> bookList = new ArrayList<>();
    Integer bookId = 1;

    @Override
    public BookDto create(BookDto dto) {
        Book book = this.bookMapper.toBook(dto);
        book.setId(bookId);
        book.setCreatedAt(LocalDateTime.now());
        this.bookList.add(book);
        bookId++;
        return this.bookMapper.toBookDto(book);
    }

    @Override
    public BookDto get(Integer id) {
        for (Book book : bookList) {
            if (book.getId().equals(id)) {
                return this.bookMapper.toBookDto(book);
            }
        }
        return new BookDto();
    }

    @Override
    public BookDto update(BookDto dto, Integer id) {
        for (Book book : bookList) {
            if (book.getId().equals(id)) {
                book.setUpdatedAt(LocalDateTime.now());

                this.bookMapper.updateBook(book, dto);
                return this.bookMapper.toBookDto(book);
            }
        }
        return new BookDto();
    }

    @Override
    public BookDto delete(Integer id) {
        for (Book book : bookList) {
            if (book.getId().equals(id)) {
                book.setDeletedAt(LocalDateTime.now());
                return this.bookMapper.toBookDto(book);
            }
        }
        return new BookDto();
    }

    @Override
    public BookDto deleteById(Integer id) {
        for (Book book : bookList) {
            if (book.getId().equals(id)) {
                bookList.remove(book);
                return this.bookMapper.toBookDto(book);
            }
        }
        return new BookDto();
    }

    @Override
    public List<BookDto> getAllDeletedAtIsNull() {
        if (bookList.isEmpty()) {
            return new ArrayList<>();
        }
        return bookList.stream()
                .filter(book -> book.getDeletedAt() == null)
                .map(this.bookMapper::toBookDto).toList();
    }

    @Override
    public List<BookDto> getAllDeletedAtIsNotNull() {
        if (bookList.isEmpty()) {
            return new ArrayList<>();
        }
        return bookList.stream()
                .filter(book -> book.getDeletedAt() != null)
                .map(this.bookMapper::toBookDto).toList();
    }

    @Override
    public List<BookDto> getAll() {
        if (bookList.isEmpty()) {
            return new ArrayList<>();
        }
        return bookList.stream().map(this.bookMapper::toBookDto).toList();
    }
}
