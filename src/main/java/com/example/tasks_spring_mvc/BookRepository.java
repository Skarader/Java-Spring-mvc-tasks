package com.example.tasks_spring_mvc;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    List<Book> findAll();

    Optional<Book> findById(int id);

    Book saveBook(Book book);

    void deleteById(int id);
}
