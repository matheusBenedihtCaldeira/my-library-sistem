package com.mylibrary.controllers.collection;

import com.mylibrary.models.entities.CollectionBook;
import com.mylibrary.models.requests.BooksCollectionRequest;
import com.mylibrary.services.collection.AddBookToCollectionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/collection")
public class AddBookToCollectionController {

    @Autowired
    private AddBookToCollectionService service;

    @PostMapping("/{id}/addbook")
    public ResponseEntity<Void> addBook(@PathVariable Long id, @RequestBody BooksCollectionRequest booksCollectionRequest){
        service.addBook(id, booksCollectionRequest);
        return ResponseEntity.noContent().build();
    }
}