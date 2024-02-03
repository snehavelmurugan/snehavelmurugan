package com.carleasingsystem.api.Service;

import java.util.List;

import com.carleasingsystem.api.Entities.User;

public interface UserInterface 
{
	User saveUser(User user);

	List<User> getUsers();

	User getUserById(Long id);
	User getUserByUsername(String username);
	User getUserByEmail(String email);

	String updateUserById(Long id, User user);
	String updateUserByUsername(String username, User user);

	String deleteUserById(Long id);
	String deleteUserByUsername(String username);
    
    int isDuplicateEntry(User user);
}