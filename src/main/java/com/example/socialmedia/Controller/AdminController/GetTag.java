package com.example.socialmedia.Controller.AdminController;

import com.example.socialmedia.Model.Dto.TagDto;
import com.example.socialmedia.Service.AdminService.Tags.TagCreate;
import com.example.socialmedia.Service.AdminService.Tags.TagGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/sparx")
public class GetTag {

    @Autowired
    private TagGet tagGet;


    @GetMapping(value = "/tag")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<List<String>> getTags(){
        return new ResponseEntity<>(tagGet.getTags(), HttpStatus.OK);
    }
}
