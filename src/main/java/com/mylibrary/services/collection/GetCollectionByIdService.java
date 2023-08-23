package com.mylibrary.services.collection;

import com.mylibrary.models.entities.CollectionBook;
import com.mylibrary.repositories.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetCollectionByIdService {

    @Autowired
    private CollectionRepository repository;

    public CollectionBook getCollection(Long id){
        return repository.findById(id).get();
    }

}