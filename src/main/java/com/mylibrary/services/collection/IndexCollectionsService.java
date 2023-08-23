package com.mylibrary.services.collection;

import com.mylibrary.models.entities.CollectionBook;
import com.mylibrary.repositories.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexCollectionsService {

    @Autowired
    private CollectionRepository repository;

    public List<CollectionBook> index(){
        List<CollectionBook> list = repository.findAll();
        return list;
    }
}