package com.example.socialmedia.Controller.UserController;


import com.example.socialmedia.Security.AppUserDto;
import com.example.socialmedia.Security.AppUserService;
import com.example.socialmedia.Service.UserService.UserCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/sparx")
public class CreateUser {

    @Autowired
    private UserCreate userCreate;


    @PostMapping(value = "/signup")
    public ResponseEntity<Object> create(@Valid @RequestBody AppUserDto user)
    {
        return new ResponseEntity(userCreate.createUser(user),HttpStatus.CREATED);
    }
}
