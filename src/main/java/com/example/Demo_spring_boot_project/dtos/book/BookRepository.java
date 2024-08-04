package com.example.Demo_spring_boot_project.dtos.book;

import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query(nativeQuery = true, value = "select * from book where deleted_at is null")
    List<Book> deleteAtIsNull();

    @Query(nativeQuery = true, value = "select b.name similar to '[a-bA-B]' from book as b where b.name=?1")
    boolean checkEmail(String email);

    @Query(value = "select * from book where author_id=?1", nativeQuery = true)
    Set<Book> selectByAuthorId(Integer id);

}
