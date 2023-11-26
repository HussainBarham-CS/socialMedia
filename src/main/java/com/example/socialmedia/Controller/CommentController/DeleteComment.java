package com.example.socialmedia.Controller.CommentController;

import com.example.socialmedia.Service.UserService.UserPostCommentService.UserDeleteComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/v1/sparx/user/{commentId}/comment/delete")
public class DeleteComment {

    @Autowired
    private UserDeleteComment userDeleteComment;


    @DeleteMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<String> create(@PathVariable String commentId){
        return new ResponseEntity<String>(userDeleteComment.delete(commentId),
                HttpStatus.OK);
    }


}