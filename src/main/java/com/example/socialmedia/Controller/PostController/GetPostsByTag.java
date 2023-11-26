package com.example.socialmedia.Controller.PostController;

import com.example.socialmedia.Model.Collection.Post;
import com.example.socialmedia.Model.Dto.PostDto;
import com.example.socialmedia.PostPreview;
import com.example.socialmedia.Service.UserService.UserPostService.UserGetPostByTag;
import com.example.socialmedia.UserPreview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/sparx/user/tag/{tagId}/post")
public class GetPostsByTag {


    @Autowired
    private UserGetPostByTag userGetPostByTag;



    @GetMapping()
    @PreAuthorize(value = "hasAuthority('ROLE_USER')")
    public ResponseEntity<List<PostPreview>> getAllProducts(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "1") int size,
            @RequestParam(value = "sort", defaultValue = "registerDate") String sort,
            @PathVariable String tagId
    ) {
        return new ResponseEntity<>(userGetPostByTag.getAllByTag(page, size, sort,tagId), HttpStatus.OK);
    }
}
