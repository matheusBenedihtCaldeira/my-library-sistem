package com.mylibrary.services.user;

import com.mylibrary.models.entities.User;
import com.mylibrary.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexUsersService {

    @Autowired
    private UserRepository repository;

    public List<User> index(){
        List<User> list = repository.findAll();
        return list;
    }
}