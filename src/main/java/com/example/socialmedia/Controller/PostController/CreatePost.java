package com.example.socialmedia.Controller.PostController;


import com.example.socialmedia.Model.Dto.PostDto;
import com.example.socialmedia.Service.UserService.UserPostService.UserCreatePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/sparx/user/post")
public class CreatePost {

    @Autowired
    private UserCreatePost userCreatePost;


    @PostMapping(value = "/create")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<PostDto> create(@Valid @RequestBody PostDto postDto)
    {
        return new ResponseEntity(userCreatePost.create(postDto), HttpStatus.CREATED);
    }





}
