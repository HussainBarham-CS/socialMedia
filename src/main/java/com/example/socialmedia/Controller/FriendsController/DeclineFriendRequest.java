package com.example.socialmedia.Controller.FriendsController;

import com.example.socialmedia.Service.UserService.UserFriendsService.UserDeclineRequest;
import com.example.socialmedia.Service.UserService.UserFriendsService.UserSendRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v1/sparx/user/declineRequest/{requestId}")
public class DeclineFriendRequest {

    @Autowired
    private UserDeclineRequest userDeclineRequest;

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<String> declineRequest(@PathVariable String requestId){
        return new ResponseEntity(userDeclineRequest.decline(requestId), HttpStatus.OK);
    }
}