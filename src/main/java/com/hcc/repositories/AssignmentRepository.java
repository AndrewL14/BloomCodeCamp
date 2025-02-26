package com.hcc.repositories;

import com.hcc.entities.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository(value = "assignments")
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    Optional<Assignment> findById(Long id);
    Optional<List<Assignment>> findByUserId(Long id);
//    Optional<Assignment> saveAssignment(Assignment assignment);
//    Optional<Assignment> createAssignment(Assignment assignment);
    //void deleteAssignment(Assignment assignment);
}
