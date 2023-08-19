package com.mylibrary.services.book;

import com.mylibrary.models.entities.Book;
import com.mylibrary.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetBookByIdService {

    @Autowired
    private BookRepository repository;

    public Book getBookById(Long id){
        Book book = repository.findById(id).get();
        return book;
    }
}