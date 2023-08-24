package com.mylibrary.services.collection;

import com.mylibrary.models.entities.Book;
import com.mylibrary.models.entities.BooksCollection;
import com.mylibrary.models.entities.CollectionBook;
import com.mylibrary.models.requests.BooksCollectionRequest;
import com.mylibrary.repositories.BookRepository;
import com.mylibrary.repositories.CollectionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddBookToCollectionService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CollectionRepository collectionRepository;

    public void addBook(Long collectionId, BooksCollectionRequest booksCollectionRequest) {
        CollectionBook collectionBookFromDB = findCollectionById(collectionId);
        var book = findBookById(booksCollectionRequest.getBookId());
        var notes = booksCollectionRequest.getNotes();
        BooksCollection booksCollection = new BooksCollection();
        booksCollection.setBook(book);
        booksCollection.setNotes(notes);
        collectionBookFromDB.getBooksCollection().add(booksCollection);
        collectionRepository.save(collectionBookFromDB);
    }

    public CollectionBook findCollectionById(Long id){
        return collectionRepository.findById(id).get();
    }

    public Book findBookById(Long id){
        return bookRepository.findById(id).get();
    }

}