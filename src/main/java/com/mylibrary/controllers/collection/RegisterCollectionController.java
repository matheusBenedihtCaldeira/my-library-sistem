package com.mylibrary.controllers.collection;

import com.mylibrary.models.dto.CollectionDTO;
import com.mylibrary.models.entities.Collection;
import com.mylibrary.services.collection.RegisterCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/create/collection")
public class RegisterCollectionController {

    @Autowired
    private RegisterCollectionService service;

    @PostMapping
    public ResponseEntity<Collection> registerCollection(@RequestBody CollectionDTO collectionDTO){
        Collection collection = service.registerCollection(collectionDTO);
        return ResponseEntity.ok().body(collection);
    }
}
