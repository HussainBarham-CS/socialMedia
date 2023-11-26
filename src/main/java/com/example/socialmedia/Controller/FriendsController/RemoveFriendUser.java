package com.example.socialmedia.Controller.FriendsController;

import com.example.socialmedia.Service.UserService.UserFriendsService.UserRemoveFriend;
import com.example.socialmedia.Service.UserService.UserFriendsService.UserSendRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/sparx/user/removeFriend/{userId}")
public class RemoveFriendUser {

    @Autowired
    private UserRemoveFriend userRemoveFriend;

    @DeleteMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<String> deleteFriend(@PathVariable String userId){
        return new ResponseEntity(userRemoveFriend.remove(userId), HttpStatus.OK);
    }
}