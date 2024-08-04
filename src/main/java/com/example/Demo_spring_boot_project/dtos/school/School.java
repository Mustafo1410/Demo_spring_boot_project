package com.example.Demo_spring_boot_project.dtos.school;

import com.example.Demo_spring_boot_project.dtos.book.Book;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "school")
@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer pupils;

   /* @OneToOne(mappedBy = "school")
    private Book book;*/

    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private LocalDateTime deleteAt;


}
