package br.com.mercadolivre.bootcamp.mongodb.exerciciospringmongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "books")
public class Book {
    @Id
    private String id;
    private String author;
    @Field(name="book")
    private String bookTitle;

    public Book() {
    }

    public Book(String id, String author, String bookTitle) {
        this.id = id;
        this.author = author;
        this.bookTitle = bookTitle;
    }

    public Book(String author, String bookTitle) {
        this.author = author;
        this.bookTitle = bookTitle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
}
