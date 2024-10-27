package com.example.tasks_spring_mvc;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepositoryImplement bookRepository;

    @Autowired
    public BookService(BookRepositoryImplement bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(int id) {
        return bookRepository.findById(id);
    }

    public Book addNewBook(Book book) {
        return bookRepository.saveBook(book);
    }

    public void removeBookById(int id) {
        bookRepository.deleteById(id);
    }
}
