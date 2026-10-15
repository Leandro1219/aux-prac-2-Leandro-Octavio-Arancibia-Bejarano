package com.example.biblioteca.dto;

public record BookResponse(
        Long id,
        String title,
        String author,
        String isbn,
        Integer publicationYear,
        String category,
        Boolean available
) {}