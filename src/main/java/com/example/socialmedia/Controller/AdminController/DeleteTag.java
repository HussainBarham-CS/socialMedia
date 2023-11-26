package com.example.socialmedia.Controller.AdminController;

import com.example.socialmedia.Model.Dto.TagDto;
import com.example.socialmedia.Service.AdminService.Tags.TagCreate;
import com.example.socialmedia.Service.AdminService.Tags.TagDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/sparx/admin")
public class DeleteTag {

    @Autowired
    private TagDelete tagDelete;


    @DeleteMapping(value = "/deleteTag/{tagId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> createTag(@Valid @PathVariable String tagId){
        return new ResponseEntity<>(tagDelete.deleteTag(tagId), HttpStatus.OK);
    }
}