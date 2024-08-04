package com.example.Demo_spring_boot_project.dtos.author;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/author/")
public class AuthorController implements AuthorServics<Integer, AuthorDto> {
    private final AuthorServiceSimple authorServicsSimple;

    @Override
    @PostMapping("/create")
    public AuthorDto create(@RequestBody AuthorDto dto) {
        return authorServicsSimple.create(dto);
    }

    @Override
    @PutMapping("/update")
    public AuthorDto update(@RequestBody AuthorDto dto, @RequestParam Integer id) {
        return authorServicsSimple.update(dto, id);
    }

    @Override
    @DeleteMapping("/delete")
    public AuthorDto delete(@RequestParam Integer id) {
        return authorServicsSimple.delete(id);
    }


    @Override
    @GetMapping("/get")
    public AuthorDto get(@RequestParam Integer id) {
        return authorServicsSimple.get(id);
    }

    @Override
    @GetMapping("/getAll")
    public List<AuthorDto> getAll() {
        return authorServicsSimple.getAll();
    }

    @GetMapping("/getAuthor")
    public AuthorDto getAuthor(@RequestParam Integer id) {
        return this.authorServicsSimple.getAuthor(id);
    }
}
