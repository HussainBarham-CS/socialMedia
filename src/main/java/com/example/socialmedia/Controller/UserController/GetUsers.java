package com.example.socialmedia.Controller.UserController;

import com.example.socialmedia.Security.AppUser;
import com.example.socialmedia.Service.UserService.UsersGet;
import com.example.socialmedia.UserPreview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/sparx")
public class GetUsers {

    @Autowired
    private UsersGet usersGet;


    @GetMapping(value="/users")
    @PreAuthorize(value = "hasAuthority('ROLE_USER')")
    public ResponseEntity<List<UserPreview>> getAllProducts(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "2") int size,
            @RequestParam(value = "sort", defaultValue = "registerDate") String sort
    ) {
        return new ResponseEntity<>(usersGet.getAll(page, size, sort), HttpStatus.OK);
    }
}
