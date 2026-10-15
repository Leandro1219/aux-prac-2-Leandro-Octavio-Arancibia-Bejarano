package com.example.biblioteca.service;

import com.example.biblioteca.dto.BookRequest;
import com.example.biblioteca.dto.BookResponse;
import com.example.biblioteca.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BookService {

    private final List<Book> books = new CopyOnWriteArrayList<>();
    private final AtomicLong nextId = new AtomicLong(1);

    public BookResponse create(BookRequest request) {
        Book book = new Book();
        book.setId(nextId.getAndIncrement());
        apply(book, request);
        books.add(book);
        return toResponse(book);
    }

    public List<BookResponse> findAll() {
        return books.stream().map(this::toResponse).toList();
    }

    public Optional<BookResponse> findById(Long id) {
        return find(id).map(this::toResponse);
    }

    public Optional<BookResponse> update(Long id, BookRequest request) {
        return find(id).map(book -> {
            apply(book, request);
            return toResponse(book);
        });
    }

    public boolean delete(Long id) {
        return books.removeIf(b -> b.getId().equals(id));
    }

    private Optional<Book> find(Long id) {
        return books.stream().filter(b -> b.getId().equals(id)).findFirst();
    }

    private void apply(Book book, BookRequest r) {
        book.setTitle(r.title());
        book.setAuthor(r.author());
        book.setIsbn(r.isbn());
        book.setPublicationYear(r.publicationYear());
        book.setCategory(r.category());
        book.setAvailable(r.available());
    }

    private BookResponse toResponse(Book b) {
        return new BookResponse(b.getId(), b.getTitle(), b.getAuthor(), b.getIsbn(),
                b.getPublicationYear(), b.getCategory(), b.getAvailable());
    }
}