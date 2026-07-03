package com.project.eventy.repository;

import com.project.eventy.entity.OrgAdmin;
import com.project.eventy.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Integer> {


}
