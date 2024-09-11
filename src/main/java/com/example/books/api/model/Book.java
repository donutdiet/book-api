package com.example.books.api.model;

public class Book {

    private String author;
    private String title;
    private String synopsis;
    private String release_date;
    private int id;

    public Book(String author, String title, String synopsis, String release_date, int id) {
        this.author = author;
        this.title = title;
        this.synopsis = synopsis;
        this.release_date = release_date;
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
