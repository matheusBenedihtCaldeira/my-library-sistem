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
    private BookRepository bookRepository;

    @Autowired
    private CollectionRepository collectionRepository;

    public void removeBookFromCollection(Long collectionId, int bookCollectionId){
        CollectionBook collectionBook = collectionRepository.findById(collectionId).get();
        collectionBook.getBooksCollection().remove(bookCollectionId);
        collectionRepository.save(collectionBook);
    }

}