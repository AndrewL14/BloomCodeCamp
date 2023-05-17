package com.hcc.services;

import com.hcc.entities.Assignment;
import com.hcc.entities.User;
import com.hcc.repositories.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {

    @Autowired
    AssignmentRepository repository;

    /**
     *  Fetches a List of Assignments related to a given user
     * @param user A valid User
     * @return List of Assignments connected to the user
     */
    public Optional<List<Assignment>> loadAssignmentsByUser(User user) {
        Long userId = user.getId();
        return repository.findByUserId(userId);
    }

    /**
     * Fetches a assignment with a valid assignment ID
     * @param id Assignment ID (it's Hash key)
     * @return A assignment matching the ID
     */
    public Optional<Assignment> loadAssignmentById(Long id) {
        return repository.findById(id);
    }

    /**
     * Saves a new or updated Assignment to the DB
     * @param assignment the Assignment to save
     */
    public void save(Assignment assignment) {
        repository.save(assignment);
    }

    /**
     * Deletes a valid assignment in the DB
     * @param assignment A valid Assignment to delete
     */
    public void delete(Assignment assignment) {
        repository.delete(assignment);
    }
}
