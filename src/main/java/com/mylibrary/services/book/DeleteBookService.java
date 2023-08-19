package com.mylibrary.services.book;

import com.mylibrary.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteBookService {

    @Autowired
    private BookRepository repository;

    public void delete(Long id){
        repository.deleteById(id);
    }
}