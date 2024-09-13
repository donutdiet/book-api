package com.example.books.service;

import com.example.books.api.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private List<Book> bookList;
    private int nextId = 1;

    public BookService() {
        bookList = new ArrayList<>();

        bookList.add(new Book("Jane Austen", "Pride and Prejudice", "A classic novel of manners that explores the issues of class, gender, and family in early 19th century England.", "1813-01-28", nextId++));
        bookList.add(new Book("George Orwell", "1984", "A dystopian novel set in a totalitarian society ruled by Big Brother, exploring themes of surveillance, censorship, and individuality.", "1949-06-08", nextId++));
        bookList.add(new Book("J.K. Rowling", "Harry Potter and the Sorcerer's Stone", "The first book in the Harry Potter series, where a young wizard discovers his magical heritage and begins his journey at Hogwarts School of Witchcraft and Wizardry.", "1997-06-26", nextId++));
        bookList.add(new Book("F. Scott Fitzgerald", "The Great Gatsby", "A novel set in the Roaring Twenties that critiques the American Dream through the story of the enigmatic Jay Gatsby and his pursuit of wealth and love.", "1925-04-10", nextId++));
        bookList.add(new Book("Harper Lee", "To Kill a Mockingbird", "A novel that addresses serious issues such as racial injustice and moral growth through the perspective of a young girl named Scout Finch in the Deep South.", "1960-07-11", nextId++));
        bookList.add(new Book("J.R.R. Tolkien", "The Hobbit", "A fantasy novel about the adventures of Bilbo Baggins, a hobbit who joins a group of dwarves on a quest to reclaim their homeland from the dragon Smaug.", "1937-09-21", nextId++));
        bookList.add(new Book("Margaret Atwood", "The Handmaid's Tale", "A dystopian novel that depicts a totalitarian society where women are oppressed and used for reproductive purposes, exploring themes of power, control, and resistance.", "1985-09-10", nextId++));
        bookList.add(new Book("Dan Brown", "The Da Vinci Code", "A mystery thriller that follows Harvard symbologist Robert Langdon as he unravels clues related to religious secrets and historical conspiracies.", "2003-03-18", nextId++));
        bookList.add(new Book("Leo Tolstoy", "War and Peace", "A historical novel that intertwines the lives of several aristocratic families against the backdrop of the Napoleonic Wars and Russian society.", "1869-01-01", nextId++));
        bookList.add(new Book("Isaac Asimov", "Foundation", "A science fiction novel that explores the rise and fall of civilizations through the lens of a mathematician who predicts the decline of a galactic empire.", "1951-06-01", nextId++));
    }

    public boolean isExists(int id) {
        for (Book book: bookList) {
            if(id == book.getId()) {
                return true;
            }
        }
        return false;
    }

    public List<Book> getBooks() {
        return bookList;
    }

    public Optional<Book> getBook(Integer id) {
        Optional<Book> optional = Optional.empty();
        for (Book book: bookList) {
            if(id == book.getId()) {
                optional = Optional.of(book);
                return optional;
            }
        }
        return optional;
    }

    public void createBook(Book book) {
        book.setId(nextId++);
        bookList.add(book);
    }

    public void updateBook(String author, String title, String synopsis, String release_date, int id) {
        for (Book book: bookList) {
            if(id == book.getId()) {
                book.setAuthor(author);
                book.setTitle(title);
                book.setSynopsis(synopsis);
                book.setRelease_date(release_date);
            }
        }
    }

    public Optional<Book> deleteBook(int id) {
        for (Book book: bookList) {
            if (book.getId() == id) {
                bookList.remove(book);
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }
}
