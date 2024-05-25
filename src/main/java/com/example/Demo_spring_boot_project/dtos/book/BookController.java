package com.example.Demo_spring_boot_project.dtos.book;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/book/")
public class BookController implements BookService<Integer, BookDto> {
    private final BookServiceImpl bookServiceImpl;

    @Override
    @PostMapping("/create")
    public BookDto create(@RequestBody BookDto dto) {
        return this.bookServiceImpl.create(dto);
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
    @GetMapping("/getAllDeletedAtIsNull")
    public List<BookDto> getAll() {
        return this.bookServiceImpl.getAll();
    }

    @Override
    @GetMapping("/getAllDeletedAtIsNotNull")
    public List<BookDto> getAllDeletedAtIsNotNull() {
        return this.bookServiceImpl.getAllDeletedAtIsNotNull();
    }
}
