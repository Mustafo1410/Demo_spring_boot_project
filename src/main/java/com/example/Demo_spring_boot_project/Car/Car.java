package com.example.Demo_spring_boot_project.Car;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
public class Car {
    private Integer id;
    private String model;
    private String color;
}
