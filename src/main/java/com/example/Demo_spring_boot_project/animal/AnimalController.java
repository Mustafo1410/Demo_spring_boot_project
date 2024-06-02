package com.example.Demo_spring_boot_project.animal;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/animal/")
public class AnimalController implements AnimalService<Integer, AnimalDto> {
    private final AnimalServiceImpl animalServiceImpl;

    @Override
    @PostMapping("/create")
    public AnimalDto create(@RequestBody AnimalDto dto) {
        return this.animalServiceImpl.create(dto);
    }

    @Override
    @GetMapping("/get")
    public AnimalDto get(@RequestParam Integer id) {
        return this.animalServiceImpl.get(id);
    }

    @Override
    @PostMapping("/update")
    public AnimalDto update(@RequestBody AnimalDto dto, @RequestParam Integer id) {
        return this.animalServiceImpl.update(dto, id);
    }

    @Override
    @DeleteMapping("/delete")
    public AnimalDto delete(@RequestParam Integer id) {
        return this.animalServiceImpl.delete(id);
    }

    @Override
    @GetMapping("/getAll")
    public List<AnimalDto> getAll() {
        return this.animalServiceImpl.getAll();
    }
}
