package com.mylibrary.services.user;

import com.mylibrary.models.entities.User;
import com.mylibrary.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserService {

    @Autowired
    private UserRepository repository;

    public User update(User data){
        User userFromDB = findById(data.getId());
        updateData(userFromDB, data);
        return repository.save(userFromDB);
    }

    public User findById(Long id){
        return repository.findById(id).get();
    }

    public void updateData(User userFromDB, User userToUpdate){
        BeanUtils.copyProperties(userToUpdate, userFromDB );
    }
}