package com.project.eventy.repository;

import com.project.eventy.entity.OrgAdmin;
import com.project.eventy.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgAdminRepository extends JpaRepository<OrgAdmin, Integer> {
    @Query("Select o from Organization o WHERE o.orgAdmin.user.username = ?2")
    OrgAdmin getOrgAdminByUsername(String username);



}
