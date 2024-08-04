package com.example.Demo_spring_boot_project.dtos.book;

import com.example.Demo_spring_boot_project.dtos.author.Author;
import com.example.Demo_spring_boot_project.dtos.school.School;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String comment;
    private String name;
    private Double price;

    private Integer page;
    private boolean delete;

    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "school_id",referencedColumnName = "id")
    private School school;*/

    //private Integer authorId;

    @ManyToMany(mappedBy = "books")
    private Set<Author>authors = new HashSet<>();


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
