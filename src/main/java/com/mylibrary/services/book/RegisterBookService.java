package com.mylibrary.services.book;

import com.mylibrary.models.dto.BookDTO;
import com.mylibrary.models.entities.Book;
import com.mylibrary.repositories.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterBookService {

    @Autowired
    private BookRepository repository;

    public Book register(BookDTO data){
        Book book = new Book();
        BeanUtils.copyProperties(data, book);
        return repository.save(book);
    }
}