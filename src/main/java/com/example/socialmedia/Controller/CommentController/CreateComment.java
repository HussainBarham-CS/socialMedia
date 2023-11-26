package com.example.socialmedia.Controller.CommentController;


import com.example.socialmedia.Model.Dto.CommentDto;
import com.example.socialmedia.Service.UserService.UserPostCommentService.UserCreateComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/sparx/user/{postId}/comment/create")
public class CreateComment {

    @Autowired
    private UserCreateComment userCreateComment;


    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<CommentDto> create(@Valid @RequestBody CommentDto commentDto,
                                             @PathVariable String postId){
        return new ResponseEntity<CommentDto>(userCreateComment.create(postId,commentDto),
                HttpStatus.CREATED);

    }


}
