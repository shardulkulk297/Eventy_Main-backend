package com.project.eventy.repository;

import com.project.eventy.entity.EventManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventManagerRepository extends JpaRepository<EventManager, Integer> {

}
