package com.mylibrary.services.collection;

import com.mylibrary.models.dto.BooksCollectionDTO;
import com.mylibrary.models.dto.CollectionDTO;
import com.mylibrary.models.entities.BooksCollection;
import com.mylibrary.models.entities.Collection;
import com.mylibrary.models.entities.User;
import com.mylibrary.repositories.BookRepository;
import com.mylibrary.repositories.CollectionRepository;
import com.mylibrary.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterCollectionService {

    @Autowired
    private CollectionRepository collectionRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public Collection registerCollection(CollectionDTO collectionDTO){
        Collection collection = new Collection();
        User user = userRepository.findById(collectionDTO.getUserId()).get();
        List<BooksCollection> booksCollections = collectionDTO.getBooksCollectionDTOList().stream().map(this::mapToDTO).toList();
        collection.setUser(user);
        collection.setBooks(booksCollections);
        return collectionRepository.save(collection);
    }

    private BooksCollection mapToDTO(BooksCollectionDTO booksCollectionDTO){
        BooksCollection booksCollection = new BooksCollection();
        booksCollection.setBook(bookRepository.findById(booksCollectionDTO.getBookId()).get());
        booksCollection.setNotes(booksCollectionDTO.getNotes());
        return booksCollection;
    }
}