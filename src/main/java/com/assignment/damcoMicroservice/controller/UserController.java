package com.assignment.damcoMicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.damcoMicroservice.constants.ApiConstants;
import com.assignment.damcoMicroservice.entity.User;
import com.assignment.damcoMicroservice.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author Kunal
 * Base Controller class for All User Rest API CRUD operations
 */
@Api(tags = ApiConstants.API_TAG, description = ApiConstants.API_DESCRIPTION)
@RestController
@RequestMapping(ApiConstants.V1_BASE_URL)
public class UserController {

	@Autowired
	UserService userService;	
	
	@ApiOperation(value =  ApiConstants.POST_DESCRIPTION, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping(path = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
	public int saveuser(@ApiParam(value = "Details of the User to Add to database") @RequestBody User user) {
		userService.saveOrUpdate(user);
		return user.getId();
	}

	@ApiOperation(value = ApiConstants.GET_ALLUSERS_DESCRIPTION, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok(userService.getAllUsers());
	}

	@ApiOperation(value = ApiConstants.GET_DESCRIPTION, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping(path = "/user/{userid}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUser(@ApiParam(value = "id of the user to fetch user details.") @PathVariable("userid") int userid) {
		return ResponseEntity.ok(userService.getUserById(userid));
	}
	
	@ApiOperation(value = ApiConstants.PUT_DESCRIPTION, 
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@PutMapping(path = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> update(@ApiParam(value = "User details to update in database") @RequestBody User user) {
		userService.saveOrUpdate(user);
		return ResponseEntity.ok(user);
	}

	@ApiOperation(value = ApiConstants.DELETE_DESCRIPTION)
	@DeleteMapping("/user/{userid}")
	public void deleteUser(@ApiParam(value = "id of the user to delete user details.") @PathVariable("userid") int userid) {
		userService.delete(userid);
	}

}
