package com.mylibrary.controllers.collection;

import com.mylibrary.models.entities.Collection;
import com.mylibrary.services.collection.GetCollectionByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/collection")
public class GetCollectionByIdController {

    @Autowired
    private GetCollectionByIdService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Collection> getCollection(@PathVariable Long id){
        Collection collection = service.getCollection(id);
        return ResponseEntity.ok().body(collection);
    }
}