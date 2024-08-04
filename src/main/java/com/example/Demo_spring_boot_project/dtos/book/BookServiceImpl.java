package com.example.Demo_spring_boot_project.dtos.book;

import com.example.Demo_spring_boot_project.dtos.author.Author;
import com.example.Demo_spring_boot_project.dtos.author.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService<Integer, BookDto> {
    private final BookMapper bookMapper;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Override
    public BookDto create(BookDto dto, Set<Integer> authorId) {
        Book book = this.bookMapper.toBook(dto);
        for (Integer i : authorId) {
            Author author = this.authorRepository.findById(i)
                    .orElseThrow(null);
            author.getBooks().add(book);
        }
        book.setCreatedAt(LocalDateTime.now());
        this.bookRepository.save(book);
        return this.bookMapper.toBookDto(book);
    }

    @Override
    public BookDto get(Integer id) {
        Optional<Book> optional = this.bookRepository.findById(id);
        if (optional.isPresent()) {
            Book book = optional.get();
            return this.bookMapper.toBookDto(book);
        }
        return new BookDto();
    }

    @Override
    public BookDto update(BookDto dto, Integer id) {
        Optional<Book> optional = this.bookRepository.findById(id);
        if (optional.isPresent()) {
            Book book = optional.get();
            book.setUpdatedAt(LocalDateTime.now());
            this.bookMapper.updateBook(book, dto);
            this.bookRepository.save(book);
            return this.bookMapper.toBookDto(book);
        }
        return new BookDto();
    }

    @Override
    public BookDto delete(Integer id) {
        Optional<Book> optional = this.bookRepository.findById(id);
        if (optional.isPresent()) {
            Book book = optional.get();
            book.setDeletedAt(LocalDateTime.now());
            this.bookRepository.save(book);
            return this.bookMapper.toBookDto(book);
        }
        return new BookDto();
    }

    @Override
    public BookDto deleteById(Integer id) {
        Optional<Book> optional = this.bookRepository.findById(id);
        if (optional.isPresent()) {
            Book book = optional.get();
            this.bookRepository.delete(book);
            return this.bookMapper.toBookDto(book);
        }
        return new BookDto();
    }

    @Override
    public List<BookDto> getAllDeletedAtIsNull() {
        List<Book> bookList = this.bookRepository.findAll();
        if (bookList.isEmpty()) {
            return new ArrayList<>();
        }
        return bookList.stream()
                .filter(book -> book.getDeletedAt() == null)
                .map(this.bookMapper::toBookDto).toList();
    }

    @Override
    public List<BookDto> getAllDeletedAtIsNotNull() {
        List<Book> bookList = this.bookRepository.findAll();
        if (bookList.isEmpty()) {
            return new ArrayList<>();
        }
        return bookList.stream()
                .filter(book -> book.getDeletedAt() != null)
                .map(this.bookMapper::toBookDto).toList();
    }

    @Override
    public List<BookDto> getAll() {
        List<Book> bookList = this.bookRepository.findAll();
        if (bookList.isEmpty()) {
            return new ArrayList<>();
        }
        return bookList
                .stream()
                .map(this.bookMapper::toBookDto)
                .toList();
    }

    public List<BookDto> deleted_at_is_null() {
        return this.bookRepository.deleteAtIsNull()
                .stream()
                .map(this.bookMapper::toBookDto)
                .toList();
    }

    @Override
    public Book createBook(Book book) {
        book.setCreatedAt(LocalDateTime.now());
        return this.bookRepository.save(book);
    }

    @Override
    public String createBookForAuthor(Integer authorId, Integer book_id) {
        Book book = this.bookRepository.findById(book_id)
                .orElseThrow(null);
        Author author = this.authorRepository.findById(authorId)
                .orElseThrow(null);
        author.getBooks().add(book);
        this.authorRepository.save(author);
        return "AUTHOR AND BOOK ARE CONNECTED";
    }
}

