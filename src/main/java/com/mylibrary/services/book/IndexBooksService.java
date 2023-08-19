package com.mylibrary.services.book;

import com.mylibrary.models.entities.Book;
import com.mylibrary.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexBooksService {

    @Autowired
    private BookRepository repository;

    public List<Book> index(){
        List<Book> books = repository.findAll();
        return books;
    }
}