package com.example.books.api.controller;

import com.example.books.api.model.Book;
import com.example.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(path = "/books")
    public ResponseEntity<List<Book>> getBooks() {
        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.OK);
    }

    @GetMapping(path = "/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
        Optional<Book> book = bookService.getBook(id);

        if (book.isPresent()) {
            return new ResponseEntity<>(book.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "/books")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        bookService.createBook(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @PutMapping(path = "/books/{id}")
    public ResponseEntity<Book> updateBook(
            @PathVariable("id") int id, @RequestBody Book book
    ) {
        if(!bookService.isExists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        bookService.updateBook(book.getAuthor(), book.getTitle(), book.getSynopsis(), book.getRelease_date(), id);

        Book updatedBook = bookService.getBook(id).orElse(null);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    @DeleteMapping(path = "/books/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable("id") int id) {
        Optional<Book> deletedBook = bookService.deleteBook(id);

        if(deletedBook.isPresent()) {
            return new ResponseEntity<>(deletedBook.get(), HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
