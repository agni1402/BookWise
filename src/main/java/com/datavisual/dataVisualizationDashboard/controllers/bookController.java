package com.datavisual.dataVisualizationDashboard.controllers;

import com.datavisual.dataVisualizationDashboard.model.Book;
import com.datavisual.dataVisualizationDashboard.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class bookController {
    @Autowired
    private BookService bookService;
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(){
        List<Book> lis = this.bookService.getAllBooks();
        if(lis.size() <= 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(lis));
    }
    @GetMapping("books/{id}")
    public ResponseEntity<Book> getOneBookByid(@PathVariable("id") int id){
        Book book = this.bookService.getBookById(id);
        if(book == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }
    @PostMapping("/books")
    public ResponseEntity<Book> plusBook(@RequestBody Book book){
       try {
           Book bu = null;
           bu = this.bookService.addbook(book);
           return ResponseEntity.status(HttpStatus.CREATED).build();
       }
       catch (Exception e){
           e.printStackTrace();
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
    }
    @DeleteMapping("/books")
    public ResponseEntity<Book> deleteAllBook(){
        try {
            this.bookService.deleteAllBooks();
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") int id){
        try {
            this.bookService.deleteBook(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable("id") int id){
       try {
           this.bookService.updateBook(book, id);
           return ResponseEntity.ok().body(book);
       }
       catch (Exception e){
           e.printStackTrace();
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
    }
}
