package com.project.eventy.controller;

import com.project.eventy.entity.SuperAdminProfile;
import com.project.eventy.service.SuperAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SuperAdminController {

    @Autowired
    private SuperAdminService superAdminService;

    @PostMapping("/api/superAdmin/add")
    public ResponseEntity<?> addSuperAdmin(@RequestBody SuperAdminProfile superAdminProfile){
        return ResponseEntity.status(HttpStatus.CREATED).body(superAdminService.addSuperAdmin(superAdminProfile));
    }
}
