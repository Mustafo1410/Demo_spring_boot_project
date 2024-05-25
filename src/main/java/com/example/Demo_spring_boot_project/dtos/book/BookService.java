package com.example.Demo_spring_boot_project.dtos.book;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookService<K, V> {
    V create(V dto);

    V get(K id);

    V update(V dto, K id);

    V delete(K id);

    List<V> getAll();

    List<V> getAllDeletedAtIsNotNull();
}
