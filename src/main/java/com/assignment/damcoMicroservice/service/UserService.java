package com.assignment.damcoMicroservice.service;

import java.util.List;

import com.assignment.damcoMicroservice.entity.User;

/**
 * @author Kunal
 * User CRUD Operations abstraction layer
 */
public interface UserService {

	List<User> getAllUsers();

	User getUserById(int id);

	void saveOrUpdate(User user);

	void delete(int id);

	void update(User user, int userid);

}
