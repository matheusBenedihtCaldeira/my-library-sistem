package com.mylibrary.services.collection;

import com.mylibrary.models.entities.BooksCollection;
import com.mylibrary.models.entities.CollectionBook;
import com.mylibrary.repositories.BookRepository;
import com.mylibrary.repositories.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoveBookToCollectionService {

    @Autowired
    private CollectionRepository collectionRepository;

    public void removeBookFromCollection(Long collectionId, int bookCollectionId){
        CollectionBook collectionBook = findById(collectionId);
        collectionBook.getBooksCollection().remove(bookCollectionId - 1);
        collectionRepository.save(collectionBook);
    }

    public CollectionBook findById(Long id){
        return collectionRepository.findById(id).get();
    }

}