package com.mylibrary.controllers.book;

import com.mylibrary.models.dto.BookDTO;
import com.mylibrary.models.entities.Book;
import com.mylibrary.services.book.UpdateBookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/update")
public class UpdateBookController {

    @Autowired
    private UpdateBookService service;

    @PutMapping(value = "/book/{id}")
    public ResponseEntity<Book> update(@RequestBody BookDTO dataDTO, @PathVariable Long id){
        Book book = new Book();
        BeanUtils.copyProperties(dataDTO, book);
        book.setId(id);
        service.update(book);
        return ResponseEntity.noContent().build();
    }
}