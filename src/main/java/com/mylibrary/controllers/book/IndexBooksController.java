package com.mylibrary.controllers.book;

import com.mylibrary.models.entities.Book;
import com.mylibrary.services.book.IndexBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/index")
public class IndexBooksController {

    @Autowired
    private IndexBooksService service;

    @GetMapping(value = "/book")
    public ResponseEntity<List<Book>> index(){
        List<Book> books = service.index();
        return ResponseEntity.ok().body(books);
    }
}