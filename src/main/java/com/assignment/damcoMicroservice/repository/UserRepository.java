package com.assignment.damcoMicroservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment.damcoMicroservice.entity.User;

/**
 * @author Kunal
 * CrudRepository for User CRUD operations
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer>
{
}

