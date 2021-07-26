package br.com.mercadolivre.bootcamp.mongodb.exerciciospringmongodb.controller;

import br.com.mercadolivre.bootcamp.mongodb.exerciciospringmongodb.entity.Book;
import br.com.mercadolivre.bootcamp.mongodb.exerciciospringmongodb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/mongoexample")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/books")
    public List<Book> getAllBooks(){
        return bookService.findAllBooks();
    }

    @PostMapping("/books")
    public Book insertBook(@RequestBody Book book){
        return bookService.insertBook(book);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> removeBook(@PathVariable String id){
        bookService.removeBook(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable String id){
        return bookService.getBook(id);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<?> updateBook(@PathVariable String id, @RequestBody Book book){
        Book newBook = new Book(id, book.getAuthor(), book.getBookTitle());
        bookService.updateBook(newBook);
        return ResponseEntity.ok().build();
    }
}
