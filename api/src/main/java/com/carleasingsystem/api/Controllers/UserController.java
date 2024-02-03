package com.carleasingsystem.api.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carleasingsystem.api.Entities.User;
import com.carleasingsystem.api.Service.UserService;
import com.carleasingsystem.api.Service.UtilityService;

@CrossOrigin
@RestController
@RequestMapping("/cls/users")
public class UserController 
{
    @Autowired
    private UserService userService;

    @Autowired
    private UtilityService utilityService;

	@GetMapping("") //to get all users from database
	public ResponseEntity<List<User>> getUsers()
	{
        System.out.println("firing");
		return ResponseEntity.ok(userService.getUsers());
	}

	@PostMapping("") //to store users in database
	public String saveUser(@RequestBody User user)
	{
        return userService.usersave(user);
	}

	@GetMapping("/{value}") // to get one user by id username
	public User getUserById(@PathVariable("value") String value)
	{
        return userService.userGetId(value);
	}

	@PutMapping("/{value}") //user update by id username
	public String updateUser(@PathVariable("value") String value, @RequestBody User user)
	{
		return userService.userupdate(value, user);
	}

	@DeleteMapping("/{value}") //to delete by id / username
	public String deleteUserById(@PathVariable("value") String value)
	{
        return userService.userDeleteId(value);
	}
}