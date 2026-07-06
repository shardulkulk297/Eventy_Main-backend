package com.project.eventy.service;

import com.project.eventy.entity.OrgAdmin;
import com.project.eventy.entity.Organization;
import com.project.eventy.exception.ResourceNotFoundException;
import com.project.eventy.repository.OrgAdminRepository;
import com.project.eventy.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {

    @Autowired
    private OrgAdminRepository orgAdminRepository;
    @Autowired
    private OrganizationRepository organizationRepository;

    public Organization addOrganization(Organization organization, String username) {

        OrgAdmin orgAdmin = orgAdminRepository.getOrgAdminByUsername(username);

        organization.setCreatedBy(orgAdmin);
        organization.setUser(orgAdmin.getUser());

        return organizationRepository.save(organization);
    }

    public Organization getOrganization(int orgId)
    {
        return organizationRepository.findById(orgId).orElseThrow(()-> new ResourceNotFoundException("Organization Not Found"));
    }

    public List<Organization> getOrganizations(int orgAdminId)
    {
        return organizationRepository.getOrganizationsByOrgAdmin(orgAdminId);
    }
}
