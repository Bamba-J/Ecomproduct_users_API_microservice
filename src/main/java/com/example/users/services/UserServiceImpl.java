package com.example.users.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.users.entities.Role;
import com.example.users.entities.User;
import com.example.users.repos.RoleRepository;
import com.example.users.repos.UserRepository;

import java.util.List;

import javax.transaction.Transactional;


@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User saveUser(User user) {
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return  userRepository.save(user);
	}

	@Override
	public User findUserByUsername(String username) {
		
		return userRepository.findByUsername(username);
	}
	
	public List <User> getAll(){
		return userRepository.findAll();
	}



	@Override
	public User addRoleToUser(String username, String rolename) {
	User usr = userRepository.findByUsername(username);
	Role r = roleRepository.findByRole(rolename);
	usr.getRoles().add(r);
	return usr;
	}


	@Override
	public Role addRole(Role role) {
		
		return roleRepository.save(role);
	}



}
