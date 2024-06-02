package com.example.Demo_spring_boot_project.dtos.author;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class AuthorConfig {
    private final AuthorServiceSimple authorServiceSimple;

    @Scheduled(initialDelay = 1000, fixedDelay = 3000)
    public void getAuthor() {
        List<AuthorDto> all = this.authorServiceSimple.getAll();
        for (AuthorDto authorDto : all) {
            System.out.println(authorDto);
        }
    }
}
