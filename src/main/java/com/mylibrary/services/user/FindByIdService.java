package com.mylibrary.services.user;

import com.mylibrary.models.entities.User;
import com.mylibrary.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindByIdService {

    @Autowired
    private UserRepository repository;

    public User findById(Long id){
        User user = repository.findById(id).get();
        return user;
    }
}