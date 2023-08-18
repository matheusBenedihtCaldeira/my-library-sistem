package com.mylibrary.controllers.user;

import com.mylibrary.models.entities.User;
import com.mylibrary.services.user.IndexUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/index")
public class IndexUsersControllers {

    @Autowired
    private IndexUsersService service;

    @GetMapping(value = "/user")
    public ResponseEntity<List<User>> index(){
        List<User> list = service.index();
        return ResponseEntity.ok().body(list);
    }
}