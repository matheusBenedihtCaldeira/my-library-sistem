package com.mylibrary.controllers.book;

import com.mylibrary.models.dto.BookDTO;
import com.mylibrary.models.entities.Book;
import com.mylibrary.services.book.RegisterBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/register")
public class RegisterBookController {

    @Autowired
    private RegisterBookService service;

    @PostMapping(value = "/book")
    public ResponseEntity<Book> register(@RequestBody BookDTO data){
        Book book = service.register(data);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(book.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}