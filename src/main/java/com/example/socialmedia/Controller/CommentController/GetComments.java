package com.example.socialmedia.Controller.CommentController;

import com.example.socialmedia.Model.Dto.CommentDto;
import com.example.socialmedia.Service.UserService.UserPostCommentService.UserGetComments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/sparx/user/comment")
public class GetComments {

    @Autowired
    private UserGetComments userGetComments;


    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<List<CommentDto>> getAllComments(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "3") int size,
            @RequestParam(value = "sort", defaultValue = "registerDate") String sort
    ) {
        return new ResponseEntity<List<CommentDto>>((List<CommentDto>) userGetComments.get(page, size, sort), HttpStatus.OK);
    }


}
