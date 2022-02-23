package com.stephenlee.projectmanager.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stephenlee.projectmanager.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    // this method retrieves all the users from the database
    List<User> findAll();
    
    // find user by email for login and registration
    Optional<User> findByEmail(String email);
}