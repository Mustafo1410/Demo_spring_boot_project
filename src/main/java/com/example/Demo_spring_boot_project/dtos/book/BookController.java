package com.example.Demo_spring_boot_project.dtos.book;

import com.example.Demo_spring_boot_project.dtos.author.AuthorDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/book/")
public class BookController implements BookService<Integer, BookDto> {
    private final BookServiceImpl bookServiceImpl;

    @Override
    @PostMapping("/book/{authorId}")
    public BookDto create(@RequestBody @Valid BookDto dto, @PathVariable("authorId") Set<Integer> authorId) {
        return this.bookServiceImpl.create(dto,authorId);
    }

    @Override
    @GetMapping("/get")
    public BookDto get(@RequestParam Integer id) {
        return this.bookServiceImpl.get(id);
    }

    @Override
    @PutMapping("/update/{id}")
    public BookDto update(@RequestBody BookDto dto, @PathVariable("id") Integer id) {
        return this.bookServiceImpl.update(dto, id);
    }

    @Override
    @DeleteMapping("/delete")
    public BookDto delete(@RequestParam Integer id) {
        return this.bookServiceImpl.delete(id);
    }

    @Override
    @DeleteMapping("/deleteById")
    public BookDto deleteById(@RequestParam Integer id) {
        return this.bookServiceImpl.deleteById(id);
    }

    @Override
    @GetMapping("/getAllDeletedAtIsNull")
    public List<BookDto> getAllDeletedAtIsNull() {
        return this.bookServiceImpl.getAllDeletedAtIsNull();
    }

    @Override
    @GetMapping("/getAllDeletedAtIsNotNull")
    public List<BookDto> getAllDeletedAtIsNotNull() {
        return this.bookServiceImpl.getAllDeletedAtIsNotNull();
    }

    @Override
    @GetMapping("/getAll")
    public List<BookDto> getAll() {
        return this.bookServiceImpl.getAll();
    }

    @GetMapping("/deleted_at_is_null")
    public List<BookDto> deleted_at_is_null() {
        return this.bookServiceImpl.deleted_at_is_null();
    }

    @PostMapping("/createBook")
    public Book createBook(@RequestBody Book book) {
        return this.bookServiceImpl.createBook(book);
    }

    @Override
    @PostMapping("/{authorId}/book/{book_id}")
    public String createBookForAuthor(@PathVariable("authorId") Integer authorId, @PathVariable("book_id") Integer book_id) {
        return this.bookServiceImpl.createBookForAuthor(authorId, book_id);
    }
}
