package com.project.eventy.repository;

import com.project.eventy.entity.SuperAdminProfile;
import com.project.eventy.service.SuperAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface SuperAdminRepository extends JpaRepository<SuperAdminProfile, Integer> {


}
