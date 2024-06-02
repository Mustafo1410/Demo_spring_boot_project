package com.example.Demo_spring_boot_project.animal;

import org.springframework.stereotype.Component;

@Component
public class AnimalMapper {
    public Animal toAnimal(AnimalDto dto) {
        return Animal.builder()
                .id(dto.getId())
                .name(dto.getName())
                .age(dto.getAge())
                .gender(dto.getGender())
                .build();
    }

    public AnimalDto toDto(Animal animal) {
        return AnimalDto.builder()
                .id(animal.getId())
                .name(animal.getName())
                .age(animal.getAge())
                .gender(animal.getGender())
                .build();
    }
}
