package com.example.tasks_spring_mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryImplement implements BookRepository {
    private final List<Book> books = new ArrayList<>();

    @Autowired
    public BookRepositoryImplement() {
        books.add(new Book(1, "1984", "George Orwell", 1949));
        books.add(new Book(2, "The Shining", "Stephen King", 1977));
        books.add(new Book(3, "Harry Potter And The Deathly Hallows", "J.K. Rowling", 2007));
    }

    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public Optional<Book> findById(int id) {
        return books.stream().filter(book -> book.getId() == id).findFirst();
    }

    @Override
    public Book saveBook(Book book) {
        books.add(book);
        return book;
    }

    @Override
    public void deleteById(int id) {
        books.removeIf(book -> book.getId() == id);
    }
}
