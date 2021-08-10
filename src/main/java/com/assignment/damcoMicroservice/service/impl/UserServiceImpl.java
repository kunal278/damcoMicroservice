package com.assignment.damcoMicroservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.damcoMicroservice.entity.User;
import com.assignment.damcoMicroservice.repository.UserRepository;
import com.assignment.damcoMicroservice.service.UserService;

/**
 * @author Kunal
 * Layer for business logic for User CRUD operations
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	/**
	 * getting all users record by using the method findaAll() of CrudRepository
	 */
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		userRepository.findAll().forEach(user -> users.add(user));
		return users;
	}

	/**
	 * getting a specific record by using the method findById() of CrudRepository
	 */
	public User getUserById(int id) {
		return userRepository.findById(id).get();
	}
	/**
	 * Save or update a user record
	 */
	public void saveOrUpdate(User user) {
		userRepository.save(user);
	}
	
	/**
	 * Delete a user based on input user id
	 */
	public void delete(int id) {
		userRepository.deleteById(id);
	}

	/**
	 *Update user record
	 */
	public void update(User user, int userid) {
		userRepository.save(user);
	}
}