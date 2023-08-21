package com.mylibrary.services.collection;

import com.mylibrary.models.entities.Collection;
import com.mylibrary.repositories.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexCollectionsService {

    @Autowired
    private CollectionRepository repository;

    public List<Collection> index(){
        List<Collection> list = repository.findAll();
        return list;
    }
}