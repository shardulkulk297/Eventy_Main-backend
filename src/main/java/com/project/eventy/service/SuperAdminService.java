package com.project.eventy.service;

import com.project.eventy.entity.SuperAdminProfile;
import com.project.eventy.entity.enums.Role;
import com.project.eventy.repository.SuperAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuperAdminService {

    @Autowired
    private UserService userService;
    @Autowired
    private SuperAdminRepository superAdminRepository;
    public SuperAdminProfile addSuperAdmin(SuperAdminProfile superAdminProfile) {
        superAdminProfile.getUser().setRole(Role.SUPER_ADMIN);
        userService.signUp(superAdminProfile.getUser());
        return superAdminRepository.save(superAdminProfile);
    }
}
