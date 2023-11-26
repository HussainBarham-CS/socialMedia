package com.example.socialmedia.Controller.UserController;


import com.example.socialmedia.Service.UserService.UserDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/v1/sparx/user/{userId}")
public class DeleteUser {

    @Autowired
    private UserDelete userDelete;



    @DeleteMapping()
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<String> delete(@PathVariable String userId){
        System.out.println(userId);
        return new ResponseEntity<>(userDelete.delete(userId), HttpStatus.OK);
    }

}
