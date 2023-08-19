package com.mylibrary.controllers.user;

import com.mylibrary.models.dto.UserDTO;
import com.mylibrary.models.entities.User;
import com.mylibrary.services.user.UpdateUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/update")
public class UpdateUserController {

    @Autowired
    private UpdateUserService service;

    @PutMapping(value = "user/{id}")
    public ResponseEntity<User> update(@RequestBody UserDTO dataDTO, @PathVariable Long id){
        User user = new User();
        BeanUtils.copyProperties(dataDTO, user);
        user.setId(id);
        service.update(user);
        return ResponseEntity.noContent().build();
    }
}