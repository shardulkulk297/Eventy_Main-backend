package com.project.eventy.repository;

import com.project.eventy.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Integer> {

    @Query("Select o from Organization o WHERE o.createdBy.user.id = ?1")
    List<Organization> getOrganizationsByOrgAdmin(int orgAdminId);
}
