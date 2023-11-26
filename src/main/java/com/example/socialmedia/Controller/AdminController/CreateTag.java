package com.example.socialmedia.Controller.AdminController;

import com.example.socialmedia.Model.Collection.Tag;
import com.example.socialmedia.Model.Dto.TagDto;
import com.example.socialmedia.Model.Repostiroy.TagRepo;
import com.example.socialmedia.Service.AdminService.AdminService;
import com.example.socialmedia.Service.AdminService.Tags.TagCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/sparx/admin")
public class CreateTag {

    @Autowired
    private TagCreate tagCreate;


    @PostMapping(value = "/createTag")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<TagDto> createTag(@Valid @RequestBody TagDto tagDto){
        return new ResponseEntity<>(tagCreate.createTag(tagDto), HttpStatus.CREATED);
    }
}
