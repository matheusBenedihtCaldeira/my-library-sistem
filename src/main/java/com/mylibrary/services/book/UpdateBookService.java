package com.mylibrary.services.book;

import com.mylibrary.models.entities.Book;
import com.mylibrary.repositories.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateBookService {

    @Autowired
    private BookRepository repository;

    public Book update(Book dataToUpdate){
        Book bookFromDB = findById(dataToUpdate.getId());
        updateData(bookFromDB, dataToUpdate);
        return repository.save(bookFromDB);
    }

    public Book findById(Long id){
        return repository.findById(id).get();
    }

    public void updateData(Book bookFromDB, Book bookToUpdate){
        BeanUtils.copyProperties(bookToUpdate, bookFromDB);
    }

}