package com.project.eventy.repository;

import com.project.eventy.entity.EventManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventManagerRepository extends JpaRepository<EventManager, Integer> {

    @Query("Select u from EventManager u WHERE u.user.username = ?1")
    EventManager getByUsername(String username);


}
