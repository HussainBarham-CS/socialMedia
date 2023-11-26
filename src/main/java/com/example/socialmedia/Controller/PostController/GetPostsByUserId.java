package com.example.socialmedia.Controller.PostController;


import com.example.socialmedia.Model.Collection.Post;
import com.example.socialmedia.PostPreview;
import com.example.socialmedia.Service.UserService.UserPostService.UserGetPostsByUserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/sparx/user/{userId}/post")
public class GetPostsByUserId {



    @Autowired
    private UserGetPostsByUserId userGetPosts;


    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<List<PostPreview>> getPostsByUserId(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "1") int size,
            @RequestParam(value = "sort", defaultValue = "registerDate") String sort,
            @PathVariable String userId
    ){
        return new ResponseEntity<>(userGetPosts.getPostsByUserId(page,size,sort,userId), HttpStatus.OK);
    }
}
