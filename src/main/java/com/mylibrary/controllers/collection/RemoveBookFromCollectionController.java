package com.mylibrary.controllers.collection;

import com.mylibrary.services.collection.RemoveBookToCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/collection")
public class RemoveBookFromCollectionController {

    @Autowired
    private RemoveBookToCollectionService service;

    @DeleteMapping(value = "/{collectionId}/remove-book/{bookCollectionId}")
    public ResponseEntity<Void> removeBookFromCollection(@PathVariable Long collectionId, @PathVariable int bookCollectionId){
        service.removeBookFromCollection(collectionId, bookCollectionId);
        return ResponseEntity.noContent().build();
    }

}
