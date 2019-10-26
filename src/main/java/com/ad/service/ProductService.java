package com.ad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ad.model.User;
import com.ad.repository.UserMongoRepository;

@Service
public class ProductService {

	@Autowired
	private UserMongoRepository repo;

	public User getUserByName(String userName) {
		return repo.findByName(userName);
	}

	public List<User> getAllUsers() {
		return repo.findAll();
	}

	public String saveUser(User user) {
		User savedUser = repo.save(user);
		return (null != savedUser) ? "Successfully created the user" : "User creation failed";
	}

	public User updateUser(User user) {
		User usr = repo.findByName(user.getName());
		user.setId(usr.getId());
		User updatedUser = repo.save(user);
		return updatedUser;
	}
}
