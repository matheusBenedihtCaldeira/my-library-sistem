package com.mylibrary.controllers.book;

import com.mylibrary.models.entities.Book;
import com.mylibrary.services.book.GetBookByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/book")
public class GetBookByIdController {

    @Autowired
    private GetBookByIdService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> getById(@PathVariable Long id){
        Book book = service.getBookById(id);
        return ResponseEntity.ok().body(book);
    }
}