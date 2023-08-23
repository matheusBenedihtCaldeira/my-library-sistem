package com.mylibrary.controllers.collection;

import com.mylibrary.models.entities.CollectionBook;
import com.mylibrary.services.collection.IndexCollectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/index")
public class IndexCollectionsController {

    @Autowired
    private IndexCollectionsService service;

    @GetMapping(value = "/collection")
    public ResponseEntity<List<CollectionBook>> index(){
        List<CollectionBook> list = service.index();
        return ResponseEntity.ok().body(list);
    }
}
