package com.example.Demo_spring_boot_project.animal;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService<Integer, AnimalDto> {
    private final AnimalRepository animalRepository;
    private final AnimalMapper animalMapper;

    @Override
    public AnimalDto create(AnimalDto dto) {
        Animal animal = this.animalMapper.toAnimal(dto);
        this.animalRepository.save(animal);
        return this.animalMapper.toDto(animal);
    }

    @Override
    public AnimalDto get(Integer id) {
        Optional<Animal> optional = this.animalRepository.findById(id);
        if (optional.isPresent()) {
            Animal animal = optional.get();
            return this.animalMapper.toDto(animal);
        }
        return new AnimalDto();
    }

    @Override
    public AnimalDto update(AnimalDto dto, Integer id) {
        return null;
    }

    @Override
    public AnimalDto delete(Integer id) {
        Optional<Animal> optional = this.animalRepository.findById(id);
        if (optional.isPresent()) {
            this.animalRepository.deleteById(id);
            return this.animalMapper.toDto(optional.get());
        }
        return new AnimalDto();
    }

    @Override
    public List<AnimalDto> getAll() {
        List<Animal> all = this.animalRepository.findAll();
        return all.stream().map(this.animalMapper::toDto).toList();
    }
}
