package com.example.socialmedia.Controller.UserController;


import com.example.socialmedia.Security.AppUserDto;
import com.example.socialmedia.Security.AppUserService;
import com.example.socialmedia.Service.UserService.UserById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value="/api/v1/sparx/user")
public class GetUserById {

    @Autowired
    private UserById userById;



    @GetMapping(value={"/{userId}" })
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<AppUserDto> getUserById(@Valid @PathVariable String userId)
    {
        return new ResponseEntity<>(userById.getUserById(userId), HttpStatus.ACCEPTED);
    }





}
