package com.example.Demo_spring_boot_project.Car;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CarInterface<K,V> {
    V create(V car);
    V update(K id, V car);
    V delete(K id);
    V get(K id);
    List<V> getAll();

}
