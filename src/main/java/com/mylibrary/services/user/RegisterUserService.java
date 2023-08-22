package com.mylibrary.services.user;

import com.mylibrary.models.dto.UserDTO;
import com.mylibrary.models.entities.User;
import com.mylibrary.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService {

    @Autowired
    private UserRepository repository;

    public User register(UserDTO data){
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());
        data.setPassword(encryptedPassword);
        User user = new User();
        BeanUtils.copyProperties(data, user);
        return repository.save(user);
    }
}