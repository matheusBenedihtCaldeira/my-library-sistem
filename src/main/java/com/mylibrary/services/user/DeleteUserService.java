package com.mylibrary.services.user;

import com.mylibrary.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserService {

    @Autowired
    private UserRepository repository;

    public void delete(Long id){
        repository.deleteById(id);
    }
}