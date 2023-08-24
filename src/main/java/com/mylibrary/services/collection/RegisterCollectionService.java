package com.mylibrary.services.collection;

import com.mylibrary.models.requests.CollectionRequest;
import com.mylibrary.models.entities.Book;
import com.mylibrary.models.entities.BooksCollection;
import com.mylibrary.models.entities.CollectionBook;
import com.mylibrary.models.entities.User;
import com.mylibrary.repositories.BookRepository;
import com.mylibrary.repositories.CollectionRepository;
import com.mylibrary.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterCollectionService {

    @Autowired
    private CollectionRepository collectionRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public CollectionBook registerCollection(CollectionRequest collectionRequest){
        CollectionBook collectionBook = new CollectionBook();
        User user = userRepository.findById(collectionRequest.getUserId()).get();
        Book book = bookRepository.findById(collectionRequest.getBookCollection().getBookId()).get();
        var notes = collectionRequest.getBookCollection().getNotes();
        collectionBook.setUser(user);
        BooksCollection booksCollection = new BooksCollection();
        booksCollection.setBook(book);
        booksCollection.setNotes(notes);
        collectionBook.getBooksCollection().add(booksCollection);
        return collectionRepository.save(collectionBook);
    }

}