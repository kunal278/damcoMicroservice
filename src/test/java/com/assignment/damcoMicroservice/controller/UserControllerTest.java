package com.assignment.damcoMicroservice.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.assignment.damcoMicroservice.entity.User;
import com.assignment.damcoMicroservice.service.UserService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserControllerTest {

	@InjectMocks
	private UserController userController = mock(UserController.class,CALLS_REAL_METHODS);
	
	@Mock
	UserService userService;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getAllUsersTest() {
		User user = new User();
		user.setTitle("Mr");
		List<User> list = new ArrayList<User>();
		list.add(user);
		when(userService.getAllUsers()).thenReturn(list);
		assertNotNull(userController.getAllUsers());
	}
	
	@Test
	public void getUserTest() {
		User user = new User();
		user.setTitle("Mr");
		int id = 1;
		when(userService.getUserById(id)).thenReturn(user);
		assertNotNull(userController.getUser(id));
	}
	
	@Test
	public void saveuserTest() {
		User user = new User();
		user.setTitle("Mr");
		int id = 1;
		when(userController.saveuser(user)).thenReturn(id);
		assertEquals(id,userController.saveuser(user));
	}
	
	@Test
	public void updateTest() {
		User user = new User();
		user.setTitle("Mr");
		user.setId(1);
		ResponseEntity<User> userupdated = new ResponseEntity<User>(user,HttpStatus.OK);
		when(userController.update(user)).thenReturn(userupdated);
		assertNotNull(userController.update(user));
	}
	
	@Test(expected = Test.None.class)
	public void deleteTest() {
		User user = new User();
		user.setFirstName("fn");
		user.setId(11);
		userController.deleteUser(user.getId());
		}
}
