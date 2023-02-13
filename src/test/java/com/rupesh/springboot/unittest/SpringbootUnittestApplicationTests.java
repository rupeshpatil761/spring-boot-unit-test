package com.rupesh.springboot.unittest;

import com.rupesh.springboot.unittest.model.User;
import com.rupesh.springboot.unittest.model.UserType;
import com.rupesh.springboot.unittest.repository.UserRepository;
import com.rupesh.springboot.unittest.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class) // For RunWith, need to add Junit 4 in classpath
@SpringBootTest
public class SpringbootUnittestApplicationTests {

	@Autowired
	private UserService userService;

	@MockBean
	private UserRepository userRepository;

	@Test
	public void testGetAllUsers(){
		Mockito.when(userRepository.findAll()).thenReturn(getMockUserList());
		Assert.assertEquals(1,userService.getAllUsers().size());
	}

	@Test
	public void testSaveUser(){
		User user = getMockUser();
		Mockito.when(userRepository.save(user)).thenReturn(user);
		Assert.assertEquals(user.getName(), userService.addUser(user).getName());
	}

	@Test
	public void testGetUserById() {
		Mockito.when(userRepository.findById(1l)).thenReturn(Optional.of(getMockUser()));
		Assert.assertEquals(getMockUser().getName(), userService.getUserById(1l).getName());
	}

	@Test
	public void testDeleteUser() {
		User user = getMockUser();
		userService.deleteUser(user);
		Mockito.verify(userRepository,Mockito.times(1)).delete(user);
	}

	@Test
	public void testDeleteUser1() {
		User user = getMockUser();
		Mockito.when(userRepository.findById(1l)).thenReturn(Optional.of(user));
		userService.deleteUser(1l);
		Mockito.verify(userRepository,Mockito.times(1)).delete(user);
	}

	private List<User> getMockUserList(){
		return Stream.of(new User(1l,"abc","test@email.com", UserType.USER)).collect(Collectors.toList());
	}

	private User getMockUser(){
		return new User(1l,"abc","test@email.com", UserType.USER);
	}

}
