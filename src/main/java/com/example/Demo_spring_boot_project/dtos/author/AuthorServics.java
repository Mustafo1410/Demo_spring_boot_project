package com.example.Demo_spring_boot_project.dtos.author;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AuthorServics<K, V> {
    V create(V dto);

    V update(V dto, K id);

    V delete(K id);

    V get(K id);

    List<V> getAll();

}
