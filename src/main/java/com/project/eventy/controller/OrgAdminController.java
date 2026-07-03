package com.project.eventy.controller;

import com.project.eventy.entity.OrgAdmin;
import com.project.eventy.repository.OrgAdminRepository;
import com.project.eventy.service.OrgAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrgAdminController {

    @Autowired
    private OrgAdminService orgAdminService;

    @PostMapping("/api/orgAdmin/add")
    public ResponseEntity<?> addOrgAdmin(@RequestBody OrgAdmin orgAdmin){
        return ResponseEntity.status(HttpStatus.CREATED).body(orgAdminService.addOrgAdmin(orgAdmin));
    }
}
