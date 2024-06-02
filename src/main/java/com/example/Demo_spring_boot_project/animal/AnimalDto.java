package com.example.Demo_spring_boot_project.animal;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AnimalDto {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
}
