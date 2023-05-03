package com.example.users.services;


import java.util.List;

import com.example.users.entities.Role;
import com.example.users.entities.User;

public interface UserService {

	User saveUser(User user);
	User findUserByUsername (String username);
	Role addRole(Role role);
	public List <User> getAll();
	User addRoleToUser(String username, String rolename);

}
