package com.example.socialmedia.Controller.PostController;

import com.example.socialmedia.Service.UserService.UserPostService.UserDeletePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/sparx/user/post")
public class DeletePost {

    @Autowired
    private UserDeletePost userDeletePost;

    @DeleteMapping(value = "/{postId}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<String> deletePost(@Valid @PathVariable String postId){
        return new ResponseEntity<>(userDeletePost.deletePost(postId),HttpStatus.OK);
    }
}
