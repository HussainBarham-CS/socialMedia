package com.example.socialmedia.Controller.UserController;


import com.example.socialmedia.AppUserUpdate;
import com.example.socialmedia.Security.AppUserDto;
import com.example.socialmedia.Service.UserService.UserUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/sparx/user")
public class UpdateUser {

    @Autowired
    private UserUpdate userUpdate;


    @PutMapping(value = "/{userId}")
    public ResponseEntity<AppUserDto> update(@PathVariable String userId ,@Valid @RequestBody AppUserUpdate user){
        return new ResponseEntity<>(userUpdate.update(userId , user), HttpStatus.OK);
    }
}
