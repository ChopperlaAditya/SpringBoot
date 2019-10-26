package com.ad.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ad.model.User;

public interface UserMongoRepository extends MongoRepository<User, String>{
	
	public User findByName(String name);
	
	public User findByAge(int age);

}
