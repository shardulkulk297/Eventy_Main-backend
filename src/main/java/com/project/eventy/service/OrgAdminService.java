package com.project.eventy.service;

import com.project.eventy.entity.OrgAdmin;
import com.project.eventy.entity.enums.Role;
import com.project.eventy.repository.OrgAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrgAdminService {

    @Autowired
    private UserService userService;
    @Autowired
    private OrgAdminRepository orgAdminRepository;
    public OrgAdmin addOrgAdmin(OrgAdmin orgAdmin) {
        orgAdmin.getUser().setRole(Role.ORG_ADMIN);
        userService.signUp(orgAdmin.getUser());
        return orgAdminRepository.save(orgAdmin);
    }
}
