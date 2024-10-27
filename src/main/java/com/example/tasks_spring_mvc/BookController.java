package com.example.tasks_spring_mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooksInList() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable int id) {
        Optional<Book> book = bookService.getBookById(id);
        if (book.isPresent()) {
            return new ResponseEntity<>(book.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Book could not be found", HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addNewBook(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeBook(@PathVariable int id) {
        if (bookService.getBookById(id).isPresent()) {
            bookService.removeBookById(id);
            return new ResponseEntity<>("Book with id: " + id + " was removed!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Book not found!", HttpStatus.NOT_FOUND);
        }
    }
}
