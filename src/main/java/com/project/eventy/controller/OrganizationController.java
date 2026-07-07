package com.project.eventy.controller;

import com.project.eventy.entity.Organization;
import com.project.eventy.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;


    @PostMapping("/api/organization/add")
    public ResponseEntity<?> addOrganization(@RequestBody Organization organization, Principal principal){
        return ResponseEntity.status(HttpStatus.CREATED).body(organizationService.addOrganization(organization, principal.getName()));
    }

    @GetMapping("/api/organization/get/{organizationId}")
    public ResponseEntity<?> getOrganization(@PathVariable int organizationId){
        return ResponseEntity.status(HttpStatus.OK).body(organizationService.getOrganization(organizationId));
    }

    @GetMapping("/api/organization/get/{orgAdminId}")
    public ResponseEntity<?> getOrganizations(@PathVariable int orgAdminId){
        return ResponseEntity.status(HttpStatus.OK).body(organizationService.getOrganizations(orgAdminId));
    }



}
