package com.example.socialmedia.Controller.PostController;

import com.example.socialmedia.Model.Dto.PostDto;
import com.example.socialmedia.Service.UserService.UserPostService.UserGetPostById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/sparx/user/post")
public class GetPostById {

    @Autowired
    private UserGetPostById userGetPostById;


    @GetMapping(value = "/{postId}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<PostDto> getPostById(@PathVariable String postId){
        return new ResponseEntity<>(userGetPostById.getById(postId), HttpStatus.OK);
    }
}
