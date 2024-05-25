package com.example.Demo_spring_boot_project.dtos.book;

import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public Book toBook(BookDto bookDto) {
        return Book.builder()
                .id(bookDto.getId())
                .page(bookDto.getPage())
                .name(bookDto.getName())
                .price(bookDto.getPrice())
                .comment(bookDto.getComment())
                .createdAt(bookDto.getCreatedAt())
                .updatedAt(bookDto.getUpdatedAt())
                .deletedAt(bookDto.getDeletedAt())
                .build();
    }

    public BookDto toBookDto(Book book) {
        return BookDto.builder()
                .id(book.getId())
                .page(book.getPage())
                .name(book.getName())
                .price(book.getPrice())
                .comment(book.getComment())
                .createdAt(book.getCreatedAt())
                .updatedAt(book.getUpdatedAt())
                .deletedAt(book.getDeletedAt())
                .build();
    }

    public void updateBook(Book book, BookDto bookDto) {
        if (bookDto == null)
            return;
        if (bookDto.getId() != null)
            book.setId(bookDto.getId());
        if (bookDto.getPage() != null)
            book.setPage(bookDto.getPage());
        if (bookDto.getName() != null)
            book.setName(bookDto.getName());
        if (bookDto.getPrice() != null)
            book.setPrice(bookDto.getPrice());
        if (bookDto.getComment() != null)
            book.setComment(bookDto.getComment());
    }
}
