package br.com.mercadolivre.bootcamp.mongodb.exerciciospringmongodb.service;

import br.com.mercadolivre.bootcamp.mongodb.exerciciospringmongodb.entity.Book;
import br.com.mercadolivre.bootcamp.mongodb.exerciciospringmongodb.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAllBooks(){
        return this.bookRepository.findAll();
    }

    public Book insertBook(Book book){
        return this.bookRepository.insert(book);
    }

    public void removeBook(String id) {
        this.bookRepository.deleteById(id);
    }

    public void updateBook(Book book) {
        this.bookRepository.save(book);
    }

    public Book getBook(String id) {
        return this.bookRepository.findById(id).orElse(null);
    }
}
