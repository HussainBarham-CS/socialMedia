package com.example.socialmedia.Controller.PostController;

import com.example.socialmedia.PostPreview;
import com.example.socialmedia.Service.UserService.UserPostService.UserGetPosts;
import com.example.socialmedia.Service.UserService.UserPostService.UserGetPostsByUserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/sparx/user/post")
public class GetPosts {



    @Autowired
    private UserGetPosts userGetPosts;


    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<List<PostPreview>> getPostsByUserId(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "2") int size,
            @RequestParam(value = "sort", defaultValue = "registerDate") String sort,
            @RequestParam(value = "friendFirst", defaultValue = "false") Boolean friendFirst
    ){
        return new ResponseEntity<>(userGetPosts.getPosts(page,size,sort,friendFirst), HttpStatus.OK);
    }
}
