package com.example.Demo_spring_boot_project.User;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor


public class User {
    private Integer id;
    private String name;
    private Integer age;
}
