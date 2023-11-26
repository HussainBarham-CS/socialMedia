package com.example.socialmedia.Controller.PostController;

import com.example.socialmedia.AppUserUpdate;
import com.example.socialmedia.Model.Dto.PostDto;
import com.example.socialmedia.PostDtoUpdate;
import com.example.socialmedia.Service.UserService.UserPostService.UserCreatePost;
import com.example.socialmedia.Service.UserService.UserPostService.UserUpdatePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/sparx/user/post")
public class UpdatePost {

    @Autowired
    private UserUpdatePost userUpdatePost;


    @PutMapping(value = "/{postId}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<PostDtoUpdate> update(@Valid @PathVariable String postId,
                                          @Valid @RequestBody PostDtoUpdate postDtoUpdate) {
        return new ResponseEntity(userUpdatePost.update(postId,postDtoUpdate), HttpStatus.OK);}

}
