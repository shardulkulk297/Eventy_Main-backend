package com.project.eventy.repository;

import com.project.eventy.entity.OrgAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgAdminRepository extends JpaRepository<OrgAdmin, Integer> {
}
