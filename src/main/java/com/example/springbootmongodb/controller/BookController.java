package com.example.springbootmongodb.controller;

import com.example.springbootmongodb.model.Book;
import com.example.springbootmongodb.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookRepo bookRepo;

    @PostMapping("/addBook")
    public String saveBook(@RequestBody Book book){
        bookRepo.save(book);
        return "successfully added";
    }


    @GetMapping("/books")
    public ResponseEntity<?> getBook(){
        List<Book> books = bookRepo.findAll();
        System.out.println(books);
        if (books.size()>0){
            return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No To dos available",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/book/{id}")
    public Optional<Book> getBookbyID(@PathVariable int id){
        return bookRepo.findById(id);
    }


    @DeleteMapping("deleteBook/{id}")
    public String deleteBook(@PathVariable int id){
        bookRepo.deleteById(id);
        return "Deleted";
    }


    @PutMapping("/updateBook/{id}")
    public Book updateBook(@RequestBody Book book , @PathVariable int id){
       bookRepo.save(book);
       return book;
    }





}
