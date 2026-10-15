package com.example.biblioteca.dto;

public record BookRequest(
        String title,
        String author,
        String isbn,
        Integer publicationYear,
        String category,
        Boolean available
) {}
