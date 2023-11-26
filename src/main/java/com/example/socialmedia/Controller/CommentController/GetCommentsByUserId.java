package com.example.socialmedia.Controller.CommentController;

import com.example.socialmedia.CommentCreate;
import com.example.socialmedia.Service.UserService.UserPostCommentService.UserGetCommentsByPostId;
import com.example.socialmedia.Service.UserService.UserPostCommentService.UserGetCommentsByUserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/sparx/user/{userId}/comment")
public class GetCommentsByUserId {

    @Autowired
    private UserGetCommentsByUserId userGetCommentsByUserId;


    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<List<CommentCreate>> getAllComments(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "3") int size,
            @RequestParam(value = "sort", defaultValue = "registerDate") String sort,
            @PathVariable String userId
    ) {
        return new ResponseEntity<>(userGetCommentsByUserId.get(page, size, sort,userId), HttpStatus.OK);
    }


}